package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;

@Mapper(uses = MunicipalityEntityMapper.class)
public interface SectorEntityMapper {

    SectorEntityMapper INSTANCE =
            Mappers.getMapper(SectorEntityMapper.class);

    SectorJPAEntity toJPA(SectorEntity entity);
    SectorEntity toEntity(SectorJPAEntity jpaEntity);
}
