package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PruningEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningJPARepository;

@Repository
public class PruningJPARepositoryAdapter
        implements PruningRepository {

    private final PruningJPARepository repository;

    public PruningJPARepositoryAdapter(
            PruningJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PruningEntity entity) {
        repository.save(
            PruningEntityMapper.INSTANCE.toJPA(entity));
    }

    @Override
    public void update(UUID id, PruningEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PruningEntity findById(UUID id) {
        return repository.findById(id)
            .map(PruningEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }

    @Override
    public List<PruningEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(PruningEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public List<PruningEntity> findByFilter(PruningEntity filter) {
        // TODO
        return List.of();
    }
}
