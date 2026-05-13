package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.SectorRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.SectorEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.SectorJPARepository;

@Repository
public class SectorJPARepositoryAdapter implements SectorRepository {

    private final SectorJPARepository repository;

    public SectorJPARepositoryAdapter(
            SectorJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(SectorEntity entity) {
        repository.save(
            SectorEntityMapper.INSTANCE.toJPA(entity));
    }

    @Override
    public void update(UUID id, SectorEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<SectorEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(SectorEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public SectorEntity findById(UUID id) {
        return repository.findById(id)
            .map(SectorEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
