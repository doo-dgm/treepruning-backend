package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TreeJPAEntity;

public interface TreeJPARepository extends JpaRepository<TreeJPAEntity, UUID> {

    @Query("SELECT t FROM TreeJPAEntity t WHERE " +
           "(:id IS NULL OR t.id = :id) AND " +
           "(:familyId IS NULL OR t.family.id = :familyId) AND " +
           "(:sectorId IS NULL OR t.sector.id = :sectorId)")
    List<TreeJPAEntity> findByFilter(@Param("id") UUID id,
                                     @Param("familyId") UUID familyId,
                                     @Param("sectorId") UUID sectorId);
}
