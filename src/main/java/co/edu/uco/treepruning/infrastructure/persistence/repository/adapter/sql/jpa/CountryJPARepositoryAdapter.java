package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.CountryRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;

@Repository
public class CountryJPARepositoryAdapter implements CountryRepository {

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
