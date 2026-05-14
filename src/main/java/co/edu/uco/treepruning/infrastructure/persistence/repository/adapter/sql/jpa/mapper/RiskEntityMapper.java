package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.RiskJPAEntity;

@Mapper(componentModel = "spring")
public interface RiskEntityMapper {

    RiskJPAEntity toJPA(RiskEntity entity);
    RiskEntity toEntity(RiskJPAEntity jpaEntity);
    List<RiskEntity> toEntityList(List<RiskJPAEntity> jpaEntities);
}
