package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.PersonRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PersonEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PersonJPARepository;

@Repository
public class PersonJPARepositoryAdapter implements PersonRepository {

    private final PersonJPARepository repository;

    public PersonJPARepositoryAdapter(
            PersonJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PersonEntity entity) {
        repository.save(
            PersonEntityMapper.INSTANCE.toJPA(entity));
    }

    @Override
    public void update(UUID id, PersonEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<PersonEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(PersonEntityMapper.INSTANCE::toEntity)
            .toList();
    }

    @Override
    public PersonEntity findById(UUID id) {
        return repository.findById(id)
            .map(PersonEntityMapper.INSTANCE::toEntity)
            .orElse(null);
    }
}
