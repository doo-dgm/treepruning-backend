package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;

public interface DocumentRepository {
	List<DocumentEntity> findAll();
	DocumentEntity findById(UUID id);
	void update(UUID id, DocumentEntity entity);
}
