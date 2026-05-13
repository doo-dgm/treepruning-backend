package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TypeJPAEntity;

@Mapper
public interface TypeEntityMapper {

    TypeEntityMapper INSTANCE =
            Mappers.getMapper(TypeEntityMapper.class);

    TypeJPAEntity toJPA(TypeEntity entity);
    TypeEntity toEntity(TypeJPAEntity jpaEntity);
}
