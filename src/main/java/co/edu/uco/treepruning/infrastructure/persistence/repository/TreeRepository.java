package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

public interface TreeRepository {
	
    List<TreeEntity> findAll();
    
    TreeEntity findById(UUID id);
}
