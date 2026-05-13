package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.DocumentJPAEntity;

@Mapper
public interface DocumentEntityMapper {

    DocumentEntityMapper INSTANCE =
            Mappers.getMapper(DocumentEntityMapper.class);

    DocumentJPAEntity toJPA(DocumentEntity entity);
    DocumentEntity toEntity(DocumentJPAEntity jpaEntity);
}
