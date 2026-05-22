package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.QuadrilleEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.QuadrilleJPARepository;

@Repository
public class QuadrilleJPARepositoryAdapter implements QuadrilleRepository {

    private final QuadrilleJPARepository repository;
    private final QuadrilleEntityMapper mapper;

    public QuadrilleJPARepositoryAdapter(QuadrilleJPARepository repository,
            QuadrilleEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<QuadrilleEntity> findByFilter(UUID id, String quadrilleName, UUID managerId) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveName = TextHelper.isEmptyWithTrim(quadrilleName) ? null : quadrilleName.trim();
        UUID effectiveManagerId = UUIDHelper.isDefaultUUID(managerId) ? null : managerId;
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveName, effectiveManagerId));
    }
}
