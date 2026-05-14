package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.TreeEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TreeJPARepository;

@Repository
public class TreeJPARepositoryAdapter implements TreeRepository {

    private final TreeJPARepository repository;
    private final TreeEntityMapper mapper;

    public TreeJPARepositoryAdapter(TreeJPARepository repository,
            TreeEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TreeEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public TreeEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }
}
