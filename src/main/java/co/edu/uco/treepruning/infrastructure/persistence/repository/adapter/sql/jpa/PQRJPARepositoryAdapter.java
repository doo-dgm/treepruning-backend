package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.PQRRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;

@Repository
public class PQRJPARepositoryAdapter implements PQRRepository{

	@Override
	public void create(PQREntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UUID id, PQREntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PQREntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQREntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQREntity> findByFilter(PQREntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
