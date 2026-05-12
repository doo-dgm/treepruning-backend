package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;

public interface StateRepository {
	List<StateEntity> findAll();
	StateEntity findById(UUID id);
}
