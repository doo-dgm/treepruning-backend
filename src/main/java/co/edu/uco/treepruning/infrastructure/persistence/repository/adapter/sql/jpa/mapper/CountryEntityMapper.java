package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.CountryJPAEntity;

@Mapper
public interface CountryEntityMapper {

    CountryEntityMapper INSTANCE = 
            Mappers.getMapper(CountryEntityMapper.class);

    CountryJPAEntity toJPA(CountryEntity entity);
    CountryEntity toEntity(CountryJPAEntity jpaEntity);
}
