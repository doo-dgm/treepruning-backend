package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

public interface TypeRepository {
	
    List<TypeEntity> findAll();
    
    TypeEntity findById(UUID id);
}
