package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;

@Mapper(componentModel = "spring", uses = { ManagerEntityMapper.class })
public interface QuadrilleEntityMapper {

    QuadrilleJPAEntity toJPA(QuadrilleEntity entity);
    QuadrilleEntity toEntity(QuadrilleJPAEntity jpaEntity);
    List<QuadrilleEntity> toEntityList(List<QuadrilleJPAEntity> jpaEntities);
}
