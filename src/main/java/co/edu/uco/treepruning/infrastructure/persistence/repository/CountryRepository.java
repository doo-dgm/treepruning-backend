package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;

public interface CountryRepository {
	List<CountryEntity> findAll();
	CountryEntity findById(UUID id);
}
