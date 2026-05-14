package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TypeJPAEntity;

@Mapper(componentModel = "spring")
public interface TypeEntityMapper {

    TypeJPAEntity toJPA(TypeEntity entity);
    TypeEntity toEntity(TypeJPAEntity jpaEntity);
    List<TypeEntity> toEntityList(List<TypeJPAEntity> jpaEntities);
}
