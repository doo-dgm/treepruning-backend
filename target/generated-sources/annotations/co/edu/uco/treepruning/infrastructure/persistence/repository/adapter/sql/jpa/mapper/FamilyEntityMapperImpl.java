package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;
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
public class FamilyEntityMapperImpl implements FamilyEntityMapper {

    @Override
    public FamilyJPAEntity toJPA(FamilyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String scientificName = null;
        String commonName = null;

        id = entity.getId();
        scientificName = entity.getScientificName();
        commonName = entity.getCommonName();

        FamilyJPAEntity familyJPAEntity = new FamilyJPAEntity( id, scientificName, commonName );

        return familyJPAEntity;
    }

    @Override
    public FamilyEntity toEntity(FamilyJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        FamilyEntity familyEntity = new FamilyEntity();

        return familyEntity;
    }

    @Override
    public List<FamilyEntity> toEntityList(List<FamilyJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<FamilyEntity> list = new ArrayList<FamilyEntity>( jpaEntities.size() );
        for ( FamilyJPAEntity familyJPAEntity : jpaEntities ) {
            list.add( toEntity( familyJPAEntity ) );
        }

        return list;
    }
}
