package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningToolEntity;

public interface PruningToolRepository {
    void create(PruningToolEntity entity);
    void update(UUID id, PruningToolEntity entity);
    void delete(UUID id);
    List<PruningToolEntity> findAll();
    PruningToolEntity findById(UUID id);
    List<PruningToolEntity> findByFilter(UUID id, UUID pruningId, UUID toolId);
<<<<<<< Updated upstream
=======
    boolean existsByPruningAndTool(UUID pruningId, UUID toolId);
>>>>>>> Stashed changes
}
