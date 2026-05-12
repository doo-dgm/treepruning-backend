package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.DocumentRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;

@Repository
public class DocumentJPARepositoryAdapter implements DocumentRepository{

	@Override
	public List<DocumentEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, DocumentEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
