package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.StatusEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.StatusJPARepository;

@Repository
public class StatusJPARepositoryAdapter implements StatusRepository {

    private final StatusJPARepository repository;

    public StatusJPARepositoryAdapter(
            StatusJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StatusEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(StatusEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public StatusEntity findById(UUID id) {
        return repository.findById(id)
            .map(StatusEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
