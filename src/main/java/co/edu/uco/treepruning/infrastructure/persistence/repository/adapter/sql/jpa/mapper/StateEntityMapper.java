package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StateJPAEntity;

@Mapper(uses = CountryEntityMapper.class)
public interface StateEntityMapper {

    StateEntityMapper INSTANCE =
            Mappers.getMapper(StateEntityMapper.class);

    StateJPAEntity toJPA(StateEntity entity);
    StateEntity toEntity(StateJPAEntity jpaEntity);
}
