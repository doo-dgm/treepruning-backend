package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.DocumentJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T12:41:16-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class DocumentEntityMapperImpl implements DocumentEntityMapper {

    @Override
    public DocumentJPAEntity toJPA(DocumentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String code = null;

        id = entity.getId();
        name = entity.getName();
        code = entity.getCode();

        DocumentJPAEntity documentJPAEntity = new DocumentJPAEntity( id, name, code );

        return documentJPAEntity;
    }

    @Override
    public DocumentEntity toEntity(DocumentJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        DocumentEntity documentEntity = new DocumentEntity();

        return documentEntity;
    }

    @Override
    public List<DocumentEntity> toEntityList(List<DocumentJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<DocumentEntity> list = new ArrayList<DocumentEntity>( jpaEntities.size() );
        for ( DocumentJPAEntity documentJPAEntity : jpaEntities ) {
            list.add( toEntity( documentJPAEntity ) );
        }

        return list;
    }
}
