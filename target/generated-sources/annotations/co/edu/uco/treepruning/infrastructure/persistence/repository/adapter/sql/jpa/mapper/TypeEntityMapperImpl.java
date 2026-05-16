package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TypeJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class TypeEntityMapperImpl implements TypeEntityMapper {

    @Override
    public TypeJPAEntity toJPA(TypeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        TypeJPAEntity typeJPAEntity = new TypeJPAEntity( id, name );

        return typeJPAEntity;
    }

    @Override
    public TypeEntity toEntity(TypeJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        TypeEntity typeEntity = new TypeEntity();

        return typeEntity;
    }

    @Override
    public List<TypeEntity> toEntityList(List<TypeJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<TypeEntity> list = new ArrayList<TypeEntity>( jpaEntities.size() );
        for ( TypeJPAEntity typeJPAEntity : jpaEntities ) {
            list.add( toEntity( typeJPAEntity ) );
        }

        return list;
    }
}
