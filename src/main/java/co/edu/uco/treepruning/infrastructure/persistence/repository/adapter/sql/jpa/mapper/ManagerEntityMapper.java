package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

@Mapper(componentModel = "spring", uses = { PersonEntityMapper.class })
public interface ManagerEntityMapper {

    ManagerJPAEntity toJPA(ManagerEntity entity);
    ManagerEntity toEntity(ManagerJPAEntity jpaEntity);
    List<ManagerEntity> toEntityList(List<ManagerJPAEntity> jpaEntities);
}
