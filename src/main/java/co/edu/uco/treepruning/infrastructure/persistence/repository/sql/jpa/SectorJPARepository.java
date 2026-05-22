package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;

public interface SectorJPARepository extends JpaRepository<SectorJPAEntity, UUID> {

    @Query("SELECT s FROM SectorJPAEntity s WHERE " +
           "(:id IS NULL OR s.id = :id) AND " +
           "(:name IS NULL OR s.name ILIKE concat('%', CAST(:name AS String), '%'))")
    List<SectorJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("name") String name);
}
