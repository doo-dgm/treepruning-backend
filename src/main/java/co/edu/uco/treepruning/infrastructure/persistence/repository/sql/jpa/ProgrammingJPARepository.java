package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;

public interface ProgrammingJPARepository extends JpaRepository<ProgrammingJPAEntity, UUID> {

    @Query("SELECT p FROM ProgrammingJPAEntity p WHERE (:id IS NULL OR p.id = :id)")
    List<ProgrammingJPAEntity> findByFilter(@Param("id") UUID id);
}