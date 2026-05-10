package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.RiskRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;

@Repository
public class RiskJPARepositoryAdapter implements RiskRepository{

	@Override
	public List<RiskEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
