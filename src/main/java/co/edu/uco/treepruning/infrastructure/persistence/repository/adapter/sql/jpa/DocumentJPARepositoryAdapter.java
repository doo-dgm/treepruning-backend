package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.DocumentRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.DocumentEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.DocumentJPARepository;

@Repository
public class DocumentJPARepositoryAdapter implements DocumentRepository {

    private final DocumentJPARepository repository;
    private final DocumentEntityMapper mapper;

    public DocumentJPARepositoryAdapter(DocumentJPARepository repository,
            DocumentEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DocumentEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public DocumentEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new DocumentEntity());
    }

    @Override
    public void update(UUID id, DocumentEntity entity) {
        // TODO
    }
}
