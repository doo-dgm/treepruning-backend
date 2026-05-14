package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;

@Mapper(componentModel = "spring")
public interface FamilyEntityMapper {

    FamilyJPAEntity toJPA(FamilyEntity entity);
    FamilyEntity toEntity(FamilyJPAEntity jpaEntity);
    List<FamilyEntity> toEntityList(List<FamilyJPAEntity> jpaEntities);
}
