package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;

@Mapper
public interface FamilyEntityMapper {

    FamilyEntityMapper INSTANCE =
            Mappers.getMapper(FamilyEntityMapper.class);

    FamilyJPAEntity toJPA(FamilyEntity entity);
    FamilyEntity toEntity(FamilyJPAEntity jpaEntity);
}
