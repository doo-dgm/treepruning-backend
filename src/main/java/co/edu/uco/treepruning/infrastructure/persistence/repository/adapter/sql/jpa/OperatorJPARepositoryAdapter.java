package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.OperatorRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.OperatorEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.OperatorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.OperatorJPARepository;
<<<<<<< Updated upstream
=======
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.OperatorJPAEntity;
>>>>>>> Stashed changes

@Repository
public class OperatorJPARepositoryAdapter implements OperatorRepository {

    private final OperatorJPARepository repository;
    private final OperatorEntityMapper mapper;

    public OperatorJPARepositoryAdapter(OperatorJPARepository repository,
            OperatorEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(OperatorEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, OperatorEntity entity) {
<<<<<<< Updated upstream
        // TODO
=======
        repository.findById(id).ifPresent(existing -> {
            OperatorJPAEntity changes = mapper.toJPA(entity);
            existing.setPerson(changes.getPerson());
            existing.setQuadrille(changes.getQuadrille());
            repository.save(existing);
        });
>>>>>>> Stashed changes
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<OperatorEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public OperatorEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new OperatorEntity());
    }

    @Override
    public List<OperatorEntity> findByFilter(UUID id, UUID personId, UUID quadrilleId) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        UUID effectivePersonId = UUIDHelper.isDefaultUUID(personId) ? null : personId;
        UUID effectiveQuadrilleId = UUIDHelper.isDefaultUUID(quadrilleId) ? null : quadrilleId;
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectivePersonId, effectiveQuadrilleId));
    }
}
