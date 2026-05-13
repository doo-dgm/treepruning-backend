package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

@Mapper(uses = PersonEntityMapper.class)
public interface ManagerEntityMapper {

    ManagerEntityMapper INSTANCE =
            Mappers.getMapper(ManagerEntityMapper.class);

    ManagerJPAEntity toJPA(ManagerEntity entity);
    ManagerEntity toEntity(ManagerJPAEntity jpaEntity);
}
