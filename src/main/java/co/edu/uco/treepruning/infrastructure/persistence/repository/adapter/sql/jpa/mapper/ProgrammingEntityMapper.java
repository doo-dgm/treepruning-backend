package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ProgrammingJPAEntity;

@Mapper(componentModel = "spring")
public interface ProgrammingEntityMapper {

    ProgrammingJPAEntity toJPA(ProgrammingEntity entity);
    ProgrammingEntity toEntity(ProgrammingJPAEntity jpaEntity);
    List<ProgrammingEntity> toEntityList(List<ProgrammingJPAEntity> jpaEntities);
}
