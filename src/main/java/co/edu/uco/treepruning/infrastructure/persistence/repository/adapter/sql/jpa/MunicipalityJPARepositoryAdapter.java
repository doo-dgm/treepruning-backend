package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.MunicipalityRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;

@Repository
public class MunicipalityJPARepositoryAdapter implements MunicipalityRepository{

	@Override
	public List<MunicipalityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MunicipalityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
