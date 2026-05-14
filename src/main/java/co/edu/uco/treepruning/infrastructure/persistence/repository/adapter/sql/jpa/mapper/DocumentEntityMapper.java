package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.DocumentJPAEntity;

@Mapper(componentModel = "spring")
public interface DocumentEntityMapper {

    DocumentJPAEntity toJPA(DocumentEntity entity);
    DocumentEntity toEntity(DocumentJPAEntity jpaEntity);
    List<DocumentEntity> toEntityList(List<DocumentJPAEntity> jpaEntities);
}
