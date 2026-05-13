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

    public PQRJPARepositoryAdapter(PQRJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PQREntity entity) {
        repository.save(PQREntityMapper.INSTANCE.toJPA(entity));
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
            .map(PQREntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }

    @Override
    public List<PQREntity> findAll() {
        return repository.findAll()
            .stream()
            .map(PQREntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public List<PQREntity> findByFilter(PQREntity filter) {
        // TODO
        return List.of();
    }
}
