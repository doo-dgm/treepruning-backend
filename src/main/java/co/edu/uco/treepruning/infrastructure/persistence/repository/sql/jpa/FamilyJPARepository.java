package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;

public interface FamilyJPARepository extends JpaRepository<FamilyJPAEntity, UUID> {

    @Query("SELECT f FROM FamilyJPAEntity f WHERE " +
           "(:id IS NULL OR f.id = :id) AND " +
           "(:commonName IS NULL OR f.commonName ILIKE concat('%', CAST(:commonName AS String), '%')) AND " +
           "(:scientificName IS NULL OR f.scientificName ILIKE concat('%', CAST(:scientificName AS String), '%'))")
    List<FamilyJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("commonName") String commonName,
                                       @Param("scientificName") String scientificName);
}
