package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.TreeEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TreeJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;

@Repository
public class TreeJPARepositoryAdapter implements TreeRepository {

    private final TreeJPARepository repository;
    private final TreeEntityMapper mapper;

    public TreeJPARepositoryAdapter(TreeJPARepository repository,
            TreeEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(TreeEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, TreeEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            TreeJPAEntity changes = mapper.toJPA(entity);
            existing.setLongitude(changes.getLongitude());
            existing.setLatitude(changes.getLatitude());
            existing.setFamily(changes.getFamily());
            existing.setSector(changes.getSector());
            existing.setProgramming(changes.getProgramming());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<TreeEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public TreeEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new TreeEntity());
    }

    @Override
    public List<TreeEntity> findByFilter(UUID id, UUID familyId, UUID sectorId) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        UUID effectiveFamilyId = UUIDHelper.isDefaultUUID(familyId) ? null : familyId;
        UUID effectiveSectorId = UUIDHelper.isDefaultUUID(sectorId) ? null : sectorId;
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveFamilyId, effectiveSectorId));
    }
}
