package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.TypeEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TypeJPARepository;

@Repository
public class TypeJPARepositoryAdapter implements TypeRepository {

    private final TypeJPARepository repository;

    public TypeJPARepositoryAdapter(TypeJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TypeEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(TypeEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public TypeEntity findById(UUID id) {
        return repository.findById(id)
            .map(TypeEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
