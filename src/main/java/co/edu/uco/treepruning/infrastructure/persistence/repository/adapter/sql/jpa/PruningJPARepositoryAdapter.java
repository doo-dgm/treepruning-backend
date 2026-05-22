package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.pagination.PageRequest;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PruningEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;

@Repository
public class PruningJPARepositoryAdapter implements PruningRepository {

    private final PruningJPARepository repository;
    private final PruningEntityMapper mapper;

    public PruningJPARepositoryAdapter(PruningJPARepository repository,
            PruningEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(final PruningEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(final UUID id, final PruningEntity entity) {
        // TODO: implement update logic when the update use case is defined
        throw new UnsupportedOperationException("Pruning update is not yet implemented");
    }

    @Override
    public void delete(final UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PageResult<PruningEntity> findByFilter(UUID id, UUID statusId, UUID treeId,
            UUID quadrilleId, UUID typeId, LocalDate plannedDate, PageRequest pageRequest) {

        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        UUID effectiveStatusId = UUIDHelper.isDefaultUUID(statusId) ? null : statusId;
        UUID effectiveTreeId = UUIDHelper.isDefaultUUID(treeId) ? null : treeId;
        UUID effectiveQuadrilleId = UUIDHelper.isDefaultUUID(quadrilleId) ? null : quadrilleId;
        UUID effectiveTypeId = UUIDHelper.isDefaultUUID(typeId) ? null : typeId;

        // Convert domain PageRequest → Spring Data Pageable
        org.springframework.data.domain.PageRequest springPage =
                org.springframework.data.domain.PageRequest.of(pageRequest.page(), pageRequest.size());

        Page<PruningJPAEntity> page = repository.findByFilter(
                effectiveId, effectiveStatusId, effectiveTreeId,
                effectiveQuadrilleId, effectiveTypeId, plannedDate, springPage);

        return PageResult.of(
                mapper.toEntityList(page.getContent()),
                page.getTotalElements(),
                pageRequest.page(),
                pageRequest.size());
    }

    @Override
    public boolean existsByTreeAndPlannedDate(final UUID treeId, final LocalDate plannedDate) {
        return repository.existsByTree_IdAndPlannedDate(treeId, plannedDate);
    }
}
