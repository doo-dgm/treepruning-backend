package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;

public interface MunicipalityRepository {
	List<MunicipalityEntity> findAll();
	MunicipalityEntity findById(UUID id);
}
