package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PersonRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PersonEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PersonJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;

@Repository
public class PersonJPARepositoryAdapter implements PersonRepository {

    private final PersonJPARepository repository;
    private final PersonEntityMapper mapper;

    public PersonJPARepositoryAdapter(PersonJPARepository repository,
            PersonEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(PersonEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, PersonEntity entity) {
        repository.findById(id).ifPresent(existing -> {
            PersonJPAEntity changes = mapper.toJPA(entity);
            existing.setFirstName(changes.getFirstName());
            existing.setSecondName(changes.getSecondName());
            existing.setFirstLastName(changes.getFirstLastName());
            existing.setSecondLastName(changes.getSecondLastName());
            existing.setDocument(changes.getDocument());
            existing.setDocumentNumber(changes.getDocumentNumber());
            existing.setBirthDate(changes.getBirthDate());
            existing.setAddress(changes.getAddress());
            existing.setEmail(changes.getEmail());
            existing.setEmailConfirmed(changes.isEmailConfirmed());
            existing.setPhone(changes.getPhone());
            existing.setPhoneConfirmed(changes.isPhoneConfirmed());
            existing.setAge(changes.getAge());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<PersonEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public PersonEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new PersonEntity());
    }

    @Override
    public List<PersonEntity> findByFilter(UUID id, String firstName, String firstLastName) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveFirstName = TextHelper.isEmptyWithTrim(firstName) ? null : firstName.trim();
        String effectiveFirstLastName = TextHelper.isEmptyWithTrim(firstLastName) ? null : firstLastName.trim();
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveFirstName, effectiveFirstLastName));
    }
}
