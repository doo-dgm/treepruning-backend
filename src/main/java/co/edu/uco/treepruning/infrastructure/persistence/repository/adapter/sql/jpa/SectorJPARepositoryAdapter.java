package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.SectorRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.SectorEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.SectorJPARepository;

@Repository
public class SectorJPARepositoryAdapter implements SectorRepository {

    private final SectorJPARepository repository;
    private final SectorEntityMapper mapper;

    public SectorJPARepositoryAdapter(SectorJPARepository repository,
            SectorEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(SectorEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, SectorEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<SectorEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public SectorEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new SectorEntity());
    }

    @Override
    public List<SectorEntity> findByFilter(UUID id, String name) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveName = TextHelper.isEmptyWithTrim(name) ? null : name.trim();
        return mapper.toEntityList(repository.findByFilter(effectiveId, effectiveName));
    }
}
