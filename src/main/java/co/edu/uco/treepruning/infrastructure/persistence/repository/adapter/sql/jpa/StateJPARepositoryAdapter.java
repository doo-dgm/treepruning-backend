package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.StateRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;

@Repository
public class StateJPARepositoryAdapter implements StateRepository{

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
