package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StatusJPAEntity;

@Mapper(componentModel = "spring")
public interface StatusEntityMapper {

    StatusJPAEntity toJPA(StatusEntity entity);
    StatusEntity toEntity(StatusJPAEntity jpaEntity);
    List<StatusEntity> toEntityList(List<StatusJPAEntity> jpaEntities);
}
