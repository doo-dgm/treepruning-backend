package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;

@Mapper(uses = DocumentEntityMapper.class)
public interface PersonEntityMapper {

    PersonEntityMapper INSTANCE =
            Mappers.getMapper(PersonEntityMapper.class);

    PersonJPAEntity toJPA(PersonEntity entity);
    PersonEntity toEntity(PersonJPAEntity jpaEntity);
}