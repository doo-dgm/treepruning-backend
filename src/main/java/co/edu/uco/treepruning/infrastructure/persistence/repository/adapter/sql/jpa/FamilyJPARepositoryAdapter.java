package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.FamilyRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.FamilyEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.FamilyJPARepository;

@Repository
public class FamilyJPARepositoryAdapter implements FamilyRepository {

    private final FamilyJPARepository repository;
    private final FamilyEntityMapper mapper;

    public FamilyJPARepositoryAdapter(FamilyJPARepository repository,
            FamilyEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FamilyEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public FamilyEntity findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(new FamilyEntity());
    }

    @Override
    public List<FamilyEntity> findByFilter(UUID id, String commonName, String scientificName) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveCommonName = TextHelper.isEmptyWithTrim(commonName) ? null : commonName.trim();
        String effectiveScientificName = TextHelper.isEmptyWithTrim(scientificName) ? null : scientificName.trim();
        return mapper.toEntityList(repository.findByFilter(
                effectiveId, effectiveCommonName, effectiveScientificName));
    }
}
