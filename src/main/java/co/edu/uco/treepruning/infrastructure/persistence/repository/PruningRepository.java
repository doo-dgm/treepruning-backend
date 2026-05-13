package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;

public interface PruningRepository {
	
    void create(PruningEntity entity);
    
    void update(UUID id, PruningEntity entity);
    
    void delete(UUID id);
    
    PruningEntity findById(UUID id);
    
    List<PruningEntity> findAll();
    
    List<PruningEntity> findByFilter(PruningEntity filter);
}