package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.QuadrilleEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.QuadrilleJPARepository;

@Repository
public class QuadrilleJPARepositoryAdapter
        implements QuadrilleRepository {

    private final QuadrilleJPARepository repository;

    public QuadrilleJPARepositoryAdapter(
            QuadrilleJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<QuadrilleEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(QuadrilleEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public QuadrilleEntity findById(UUID id) {
        return repository.findById(id)
            .map(QuadrilleEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
