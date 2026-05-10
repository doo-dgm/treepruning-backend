package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.SectorRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;

@Repository
public class SectorJPARepositoryAdapter implements SectorRepository{

	@Override
	public void create(SectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UUID id, SectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RiskEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
