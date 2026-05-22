package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;

public interface QuadrilleJPARepository extends JpaRepository<QuadrilleJPAEntity, UUID> {

    @Query("SELECT q FROM QuadrilleJPAEntity q WHERE " +
           "(:id IS NULL OR q.id = :id) AND " +
           "(:quadrilleName IS NULL OR q.quadrilleName ILIKE concat('%', CAST(:quadrilleName AS String), '%')) AND " +
           "(:managerId IS NULL OR q.manager.id = :managerId)")
    List<QuadrilleJPAEntity> findByFilter(@Param("id") UUID id,
                                          @Param("quadrilleName") String quadrilleName,
                                          @Param("managerId") UUID managerId);
}
