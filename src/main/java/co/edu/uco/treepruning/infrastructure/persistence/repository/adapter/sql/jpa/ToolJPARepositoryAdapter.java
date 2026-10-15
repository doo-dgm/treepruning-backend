package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.ToolRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ToolEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ToolEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ToolJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ToolJPAEntity;

@Repository
public class ToolJPARepositoryAdapter implements ToolRepository {

    private final ToolJPARepository repository;
    private final ToolEntityMapper mapper;

    public ToolJPARepositoryAdapter(ToolJPARepository repository,
            ToolEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ToolEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, ToolEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            ToolJPAEntity changes = mapper.toJPA(entity);
            existing.setName(changes.getName());
            existing.setDescription(changes.getDescription());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<ToolEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public ToolEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new ToolEntity());
    }

    @Override
    public List<ToolEntity> findByFilter(UUID id, String name, String description) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveName = TextHelper.isEmptyWithTrim(name) ? null : name.trim();
        String effectiveDescription = TextHelper.isEmptyWithTrim(description) ? null : description.trim();
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveName, effectiveDescription));
    }
}
