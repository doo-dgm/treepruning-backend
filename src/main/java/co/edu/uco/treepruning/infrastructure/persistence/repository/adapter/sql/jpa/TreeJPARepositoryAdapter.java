package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.TreeEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TreeJPARepository;

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
    public List<TreeEntity> findByFilter(UUID id, UUID familyId, UUID sectorId) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        UUID effectiveFamilyId = UUIDHelper.isDefaultUUID(familyId) ? null : familyId;
        UUID effectiveSectorId = UUIDHelper.isDefaultUUID(sectorId) ? null : sectorId;
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveFamilyId, effectiveSectorId));
    }
}
