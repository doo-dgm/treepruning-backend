package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.ProgrammingRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ProgrammingEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ProgrammingJPARepository;

@Repository
public class ProgrammingJPARepositoryAdapter implements ProgrammingRepository {

    private final ProgrammingJPARepository repository;
    private final ProgrammingEntityMapper mapper;

    public ProgrammingJPARepositoryAdapter(ProgrammingJPARepository repository,
            ProgrammingEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProgrammingEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public ProgrammingEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }
}
