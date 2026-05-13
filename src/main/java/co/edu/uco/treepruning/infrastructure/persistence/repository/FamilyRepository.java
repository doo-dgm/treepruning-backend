package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;

public interface FamilyRepository {
	
    List<FamilyEntity> findAll();
    
    FamilyEntity findById(UUID id);
}
