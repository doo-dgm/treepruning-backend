package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

public interface QuadrilleRepository {
	
    List<QuadrilleEntity> findAll();
    
    QuadrilleEntity findById(UUID id);
    
}