package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;

public interface PQRRepository {
	void create(PQREntity entity);
	void update(UUID id, PQREntity entity);
	void delete(UUID id);
	PQREntity findById(UUID id);
	List<PQREntity> findAll();
	List<PQREntity> findByFilter(PQREntity filter);
}
