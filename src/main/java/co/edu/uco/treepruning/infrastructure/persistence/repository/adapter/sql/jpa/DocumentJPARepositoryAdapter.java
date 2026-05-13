package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.DocumentRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.DocumentEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.DocumentJPARepository;

@Repository
public class DocumentJPARepositoryAdapter
        implements DocumentRepository {

    private final DocumentJPARepository repository;

    public DocumentJPARepositoryAdapter(
            DocumentJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocumentEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(DocumentEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public DocumentEntity findById(UUID id) {
        return repository.findById(id)
            .map(DocumentEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }

    @Override
    public void update(UUID id, DocumentEntity entity) {
        // TODO
    }
}
