package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.ManagerRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ManagerEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ManagerJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

@Repository
public class ManagerJPARepositoryAdapter implements ManagerRepository {

    private final ManagerJPARepository repository;
    private final ManagerEntityMapper mapper;

    public ManagerJPARepositoryAdapter(ManagerJPARepository repository,
            ManagerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ManagerEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, ManagerEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            ManagerJPAEntity changes = mapper.toJPA(entity);
            existing.setPerson(changes.getPerson());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<ManagerEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public ManagerEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new ManagerEntity());
    }

    @Override
    public List<ManagerEntity> findByFilter(UUID id) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        return mapper.toEntityList(repository.findByFilter(effectiveId));
    }
}
