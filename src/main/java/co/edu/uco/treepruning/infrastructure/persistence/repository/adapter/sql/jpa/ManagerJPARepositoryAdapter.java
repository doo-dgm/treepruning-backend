package co.edu.uco.treepruning.infrastructure.persistence
        .repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.ManagerRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ManagerEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ManagerJPARepository;

@Repository
public class ManagerJPARepositoryAdapter
        implements ManagerRepository {

    private final ManagerJPARepository repository;

    public ManagerJPARepositoryAdapter(
            ManagerJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ManagerEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(ManagerEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public ManagerEntity findById(UUID id) {
        return repository.findById(id)
            .map(ManagerEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}