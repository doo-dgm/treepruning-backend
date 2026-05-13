package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StatusJPAEntity;

@Mapper
public interface StatusEntityMapper {

    StatusEntityMapper INSTANCE =
            Mappers.getMapper(StatusEntityMapper.class);

    StatusJPAEntity toJPA(StatusEntity entity);
    StatusEntity toEntity(StatusJPAEntity jpaEntity);
}
