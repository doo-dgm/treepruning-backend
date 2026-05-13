package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.MunicipalityJPAEntity;

@Mapper(uses = StateEntityMapper.class)
public interface MunicipalityEntityMapper {

    MunicipalityEntityMapper INSTANCE =
            Mappers.getMapper(MunicipalityEntityMapper.class);

    MunicipalityJPAEntity toJPA(MunicipalityEntity entity);
    MunicipalityEntity toEntity(MunicipalityJPAEntity jpaEntity);
}
