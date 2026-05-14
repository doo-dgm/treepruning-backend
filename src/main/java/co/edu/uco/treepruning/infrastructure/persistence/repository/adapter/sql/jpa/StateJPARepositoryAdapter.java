package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.StateRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.StateEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.StateJPARepository;

@Repository
public class StateJPARepositoryAdapter implements StateRepository {

    private final StateJPARepository repository;
    private final StateEntityMapper mapper;

    public StateJPARepositoryAdapter(StateJPARepository repository,
            StateEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<StateEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public StateEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }
}
