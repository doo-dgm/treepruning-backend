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

    public StateJPARepositoryAdapter(StateJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StateEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(StateEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public StateEntity findById(UUID id) {
        return repository.findById(id)
            .map(StateEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}