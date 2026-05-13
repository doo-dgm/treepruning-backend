package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;

@Mapper
public interface ProgrammingEntityMapper {

    ProgrammingEntityMapper INSTANCE =
            Mappers.getMapper(ProgrammingEntityMapper.class);

    ProgrammingJPAEntity toJPA(ProgrammingEntity entity);
    ProgrammingEntity toEntity(ProgrammingJPAEntity jpaEntity);
}