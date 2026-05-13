package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;

public interface ProgrammingRepository {
	
    List<ProgrammingEntity> findAll();
    
    ProgrammingEntity findById(UUID id);
}