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

    public TreeJPARepositoryAdapter(TreeJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TreeEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(TreeEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public TreeEntity findById(UUID id) {
        return repository.findById(id)
            .map(TreeEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
