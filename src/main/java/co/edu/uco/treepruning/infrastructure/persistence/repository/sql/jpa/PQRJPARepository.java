package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;

public interface PQRJPARepository extends JpaRepository<PQRJPAEntity, UUID> {

    @Query("SELECT p FROM PQRJPAEntity p WHERE " +
           "(:id IS NULL OR p.id = :id) AND " +
           "(:date IS NULL OR p.date = :date) AND " +
           "(:statusId IS NULL OR p.status.id = :statusId) AND " +
           "(:riskId IS NULL OR p.risk.id = :riskId) AND " +
           "(:sectorId IS NULL OR p.sector.id = :sectorId) AND " +
           "(:personId IS NULL OR p.person.id = :personId)")
    List<PQRJPAEntity> findByFilter(@Param("id") UUID id,
                                    @Param("date") LocalDate date,
                                    @Param("statusId") UUID statusId,
                                    @Param("riskId") UUID riskId,
                                    @Param("sectorId") UUID sectorId,
                                    @Param("personId") UUID personId);
}
