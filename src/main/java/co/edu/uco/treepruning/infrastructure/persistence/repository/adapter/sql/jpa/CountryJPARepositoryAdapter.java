package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.CountryRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.CountryEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.CountryJPARepository;

@Repository
public class CountryJPARepositoryAdapter implements CountryRepository {

    private final CountryJPARepository repository;
    private final CountryEntityMapper mapper;

    public CountryJPARepositoryAdapter(CountryJPARepository repository,
            CountryEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CountryEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public CountryEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new CountryEntity());
    }
}
