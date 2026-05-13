package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;

public interface SectorRepository {
	
    void create(SectorEntity entity);
    
    void update(UUID id, SectorEntity entity);
    
    void delete(UUID id);
    
    List<SectorEntity> findAll();  
    
    SectorEntity findById(UUID id);
}