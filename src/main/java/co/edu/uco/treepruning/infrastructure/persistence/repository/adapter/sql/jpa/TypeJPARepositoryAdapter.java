package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.TypeEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TypeJPARepository;

@Repository
public class TypeJPARepositoryAdapter implements TypeRepository {

    private final TypeJPARepository repository;
    private final TypeEntityMapper mapper;

    public TypeJPARepositoryAdapter(TypeJPARepository repository,
            TypeEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TypeEntity> findByFilter(UUID id, String name) {
        UUID effectiveId = UUIDHelper.isDefaultUUID(id) ? null : id;
        String effectiveName = TextHelper.isEmptyWithTrim(name) ? null : name.trim();
        return mapper.toEntityList(repository.findByFilter(effectiveId, effectiveName));
    }
}
