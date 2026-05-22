package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;

public interface PruningJPARepository extends JpaRepository<PruningJPAEntity, UUID> {

    boolean existsByTree_IdAndPlannedDate(UUID treeId, LocalDate plannedDate);

    @Query(value =
           "SELECT p FROM PruningJPAEntity p WHERE " +
           "(:id IS NULL OR p.id = :id) AND " +
           "(:statusId IS NULL OR p.status.id = :statusId) AND " +
           "(:treeId IS NULL OR p.tree.id = :treeId) AND " +
           "(:quadrilleId IS NULL OR p.quadrille.id = :quadrilleId) AND " +
           "(:typeId IS NULL OR p.type.id = :typeId) AND " +
           "(:plannedDate IS NULL OR p.plannedDate = :plannedDate)",
           countQuery =
           "SELECT COUNT(p) FROM PruningJPAEntity p WHERE " +
           "(:id IS NULL OR p.id = :id) AND " +
           "(:statusId IS NULL OR p.status.id = :statusId) AND " +
           "(:treeId IS NULL OR p.tree.id = :treeId) AND " +
           "(:quadrilleId IS NULL OR p.quadrille.id = :quadrilleId) AND " +
           "(:typeId IS NULL OR p.type.id = :typeId) AND " +
           "(:plannedDate IS NULL OR p.plannedDate = :plannedDate)")
    Page<PruningJPAEntity> findByFilter(
            @Param("id") UUID id,
            @Param("statusId") UUID statusId,
            @Param("treeId") UUID treeId,
            @Param("quadrilleId") UUID quadrilleId,
            @Param("typeId") UUID typeId,
            @Param("plannedDate") LocalDate plannedDate,
            Pageable pageable);
}
