package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.MunicipalityRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.MunicipalityEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.MunicipalityJPARepository;

@Repository
public class MunicipalityJPARepositoryAdapter implements MunicipalityRepository {

    private final MunicipalityJPARepository repository;
    private final MunicipalityEntityMapper mapper;

    public MunicipalityJPARepositoryAdapter(MunicipalityJPARepository repository,
            MunicipalityEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MunicipalityEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public MunicipalityEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new MunicipalityEntity());
    }
}
