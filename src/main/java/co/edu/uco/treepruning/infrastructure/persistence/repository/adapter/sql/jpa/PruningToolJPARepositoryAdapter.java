package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningToolRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PruningToolEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningToolEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningToolJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningToolJPAEntity;

@Repository
public class PruningToolJPARepositoryAdapter implements PruningToolRepository {

    private final PruningToolJPARepository repository;
    private final PruningToolEntityMapper mapper;

    public PruningToolJPARepositoryAdapter(PruningToolJPARepository repository,
            PruningToolEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(PruningToolEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, PruningToolEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            PruningToolJPAEntity changes = mapper.toJPA(entity);
            existing.setPruning(changes.getPruning());
            existing.setTool(changes.getTool());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<PruningToolEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public PruningToolEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new PruningToolEntity());
    }

    @Override
    public List<PruningToolEntity> findByFilter(UUID id, UUID pruningId, UUID toolId) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        UUID effectivePruningId = UUIDHelper.isDefaultUUID(pruningId) ? null : pruningId;
        UUID effectiveToolId = UUIDHelper.isDefaultUUID(toolId) ? null : toolId;
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectivePruningId, effectiveToolId));
    }

    @Override
    public boolean existsByPruningAndTool(UUID pruningId, UUID toolId) {
        return repository.existsByPruning_IdAndTool_Id(pruningId, toolId);
    }
}
