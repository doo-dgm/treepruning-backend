package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PQRRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PQREntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PQRJPARepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PQRJPAEntity;

@Repository
public class PQRJPARepositoryAdapter implements PQRRepository {

    private final PQRJPARepository repository;
    private final PQREntityMapper mapper;

    public PQRJPARepositoryAdapter(PQRJPARepository repository,
            PQREntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(PQREntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, PQREntity entity) {
        repository.findById(id).ifPresent(existing -> {
            PQRJPAEntity changes = mapper.toJPA(entity);
            existing.setDate(changes.getDate());
            existing.setStatus(changes.getStatus());
            existing.setRisk(changes.getRisk());
            existing.setSector(changes.getSector());
            existing.setPerson(changes.getPerson());
            existing.setPhotographicRecordPath(changes.getPhotographicRecordPath());
            repository.save(existing);
        });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PQREntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new PQREntity());
    }

    @Override
    public List<PQREntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public List<PQREntity> findByFilter(PQREntity filter) {
        PQREntity effectiveFilter = ObjectHelper.getDefault(filter, new PQREntity());

        UUID effectiveId = UUIDHelper.isDefaultUUID(effectiveFilter.getId())
                ? null : effectiveFilter.getId();
        LocalDate effectiveDate = DateHelper.isDefaultDate(effectiveFilter.getDate())
                ? null : effectiveFilter.getDate();
        UUID effectiveStatusId = UUIDHelper.isDefaultUUID(effectiveFilter.getStatus().getId())
                ? null : effectiveFilter.getStatus().getId();
        UUID effectiveRiskId = UUIDHelper.isDefaultUUID(effectiveFilter.getRisk().getId())
                ? null : effectiveFilter.getRisk().getId();
        UUID effectiveSectorId = UUIDHelper.isDefaultUUID(effectiveFilter.getSector().getId())
                ? null : effectiveFilter.getSector().getId();
        UUID effectivePersonId = UUIDHelper.isDefaultUUID(effectiveFilter.getPerson().getId())
                ? null : effectiveFilter.getPerson().getId();

        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveDate, effectiveStatusId,
                effectiveRiskId, effectiveSectorId, effectivePersonId));
    }
}
