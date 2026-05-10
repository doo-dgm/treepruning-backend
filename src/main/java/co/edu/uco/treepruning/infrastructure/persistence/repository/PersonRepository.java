package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;

public interface PersonRepository {
	void create(PersonEntity entity);
	void update(UUID id, PersonEntity entity);
	void delete(UUID id);
	List<PersonEntity> findAll();
	PersonEntity findById(UUID id);
}
