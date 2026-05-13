package co.edu.uco.treepruning.infrastructure.persistence
        .repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.ProgrammingRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.ProgrammingEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ProgrammingJPARepository;

@Repository
public class ProgrammingJPARepositoryAdapter
        implements ProgrammingRepository {

    private final ProgrammingJPARepository repository;

    public ProgrammingJPARepositoryAdapter(
            ProgrammingJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProgrammingEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(ProgrammingEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public ProgrammingEntity findById(UUID id) {
        return repository.findById(id)
            .map(ProgrammingEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
