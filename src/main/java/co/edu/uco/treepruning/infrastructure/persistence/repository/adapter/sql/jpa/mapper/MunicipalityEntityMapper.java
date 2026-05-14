package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.MunicipalityJPAEntity;

@Mapper(componentModel = "spring", uses = { StateEntityMapper.class })
public interface MunicipalityEntityMapper {

    MunicipalityJPAEntity toJPA(MunicipalityEntity entity);
    MunicipalityEntity toEntity(MunicipalityJPAEntity jpaEntity);
    List<MunicipalityEntity> toEntityList(List<MunicipalityJPAEntity> jpaEntities);
}
