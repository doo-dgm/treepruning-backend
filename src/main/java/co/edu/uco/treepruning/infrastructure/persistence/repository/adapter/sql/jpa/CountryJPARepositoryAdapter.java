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

    public CountryJPARepositoryAdapter(
            CountryJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CountryEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(CountryEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public CountryEntity findById(UUID id) {
        return repository.findById(id)
            .map(CountryEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
