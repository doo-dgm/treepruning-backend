package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StateJPAEntity;

@Mapper(componentModel = "spring", uses = { CountryEntityMapper.class })
public interface StateEntityMapper {

    StateJPAEntity toJPA(StateEntity entity);
    StateEntity toEntity(StateJPAEntity jpaEntity);
    List<StateEntity> toEntityList(List<StateJPAEntity> jpaEntities);
}
