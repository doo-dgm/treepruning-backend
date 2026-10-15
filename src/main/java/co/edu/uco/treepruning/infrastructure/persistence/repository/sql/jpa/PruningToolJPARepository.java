package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningToolJPAEntity;

public interface PruningToolJPARepository extends JpaRepository<PruningToolJPAEntity, UUID> {

    boolean existsByPruning_IdAndTool_Id(UUID pruningId, UUID toolId);

    @Query("SELECT pt FROM PruningToolJPAEntity pt WHERE " +
           "(:id IS NULL OR pt.id = :id) AND " +
           "(:pruningId IS NULL OR pt.pruning.id = :pruningId) AND " +
           "(:toolId IS NULL OR pt.tool.id = :toolId)")
    List<PruningToolJPAEntity> findByFilter(@Param("id") UUID id,
                                            @Param("pruningId") UUID pruningId,
                                            @Param("toolId") UUID toolId);
}
