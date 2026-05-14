package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;

@Mapper(componentModel = "spring", uses = { DocumentEntityMapper.class })
public interface PersonEntityMapper {

    PersonJPAEntity toJPA(PersonEntity entity);
    PersonEntity toEntity(PersonJPAEntity jpaEntity);
    List<PersonEntity> toEntityList(List<PersonJPAEntity> jpaEntities);
}
