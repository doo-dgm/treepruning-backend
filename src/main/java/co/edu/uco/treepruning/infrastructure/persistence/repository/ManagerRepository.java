package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;

public interface ManagerRepository {
	
    List<ManagerEntity> findAll();
    
    ManagerEntity findById(UUID id);
}
