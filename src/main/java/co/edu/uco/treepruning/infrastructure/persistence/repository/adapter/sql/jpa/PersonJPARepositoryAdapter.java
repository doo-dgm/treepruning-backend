package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.PersonRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;

@Repository
public class PersonJPARepositoryAdapter implements PersonRepository{

	@Override
	public void create(PersonEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UUID id, PersonEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
