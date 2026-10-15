package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.ProgrammingRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ProgrammingEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ProgrammingJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;

@Repository
public class ProgrammingJPARepositoryAdapter implements ProgrammingRepository {

    private final ProgrammingJPARepository repository;
    private final ProgrammingEntityMapper mapper;

    public ProgrammingJPARepositoryAdapter(ProgrammingJPARepository repository,
            ProgrammingEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ProgrammingEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, ProgrammingEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            ProgrammingJPAEntity changes = mapper.toJPA(entity);
            existing.setInitialDate(changes.getInitialDate());
            existing.setFrequencyMonths(changes.getFrequencyMonths());
            existing.setAmount(changes.getAmount());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProgrammingEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public ProgrammingEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new ProgrammingEntity());
    }

    @Override
    public List<ProgrammingEntity> findByFilter(UUID id) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        return mapper.toEntityList(repository.findByFilter(effectiveId));
    }
}
