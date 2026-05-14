package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.PQRRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PQREntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PQRJPARepository;

@Repository
public class PQRJPARepositoryAdapter implements PQRRepository {

    private final PQRJPARepository repository;
    private final PQREntityMapper mapper;

    public PQRJPARepositoryAdapter(PQRJPARepository repository,
            PQREntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(PQREntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, PQREntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PQREntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }

    @Override
    public List<PQREntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public List<PQREntity> findByFilter(PQREntity filter) {
        // TODO
        return List.of();
    }
}
