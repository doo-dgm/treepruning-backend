package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;

@Mapper(componentModel = "spring", uses = { MunicipalityEntityMapper.class })
public interface SectorEntityMapper {

    SectorJPAEntity toJPA(SectorEntity entity);
    SectorEntity toEntity(SectorJPAEntity jpaEntity);
    List<SectorEntity> toEntityList(List<SectorJPAEntity> jpaEntities);
}
