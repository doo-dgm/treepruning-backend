package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.RiskJPAEntity;

@Mapper
public interface RiskEntityMapper {

    RiskEntityMapper INSTANCE =
            Mappers.getMapper(RiskEntityMapper.class);

    RiskJPAEntity toJPA(RiskEntity entity);
    RiskEntity toEntity(RiskJPAEntity jpaEntity);
}