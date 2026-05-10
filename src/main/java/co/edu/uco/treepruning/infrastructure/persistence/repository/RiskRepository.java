package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;

public interface RiskRepository {
	List<RiskEntity> findAll();
}
