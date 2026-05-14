package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.CountryJPAEntity;

@Mapper(componentModel = "spring")
public interface CountryEntityMapper {

    CountryJPAEntity toJPA(CountryEntity entity);
    CountryEntity toEntity(CountryJPAEntity jpaEntity);
    List<CountryEntity> toEntityList(List<CountryJPAEntity> jpaEntities);
}
