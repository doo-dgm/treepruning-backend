package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

public interface ManagerJPARepository extends JpaRepository<ManagerJPAEntity, UUID> {

    @Query("SELECT m FROM ManagerJPAEntity m WHERE (:id IS NULL OR m.id = :id)")
    List<ManagerJPAEntity> findByFilter(@Param("id") UUID id);
}
