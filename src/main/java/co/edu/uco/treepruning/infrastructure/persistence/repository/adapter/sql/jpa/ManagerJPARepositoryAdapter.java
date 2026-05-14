package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.ManagerRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ManagerEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ManagerJPARepository;

@Repository
public class ManagerJPARepositoryAdapter implements ManagerRepository {

    private final ManagerJPARepository repository;
    private final ManagerEntityMapper mapper;

    public ManagerJPARepositoryAdapter(ManagerJPARepository repository,
            ManagerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ManagerEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public ManagerEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }
}
