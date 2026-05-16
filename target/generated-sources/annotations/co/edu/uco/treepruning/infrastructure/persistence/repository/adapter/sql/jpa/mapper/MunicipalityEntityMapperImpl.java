package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.MunicipalityJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StateJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class MunicipalityEntityMapperImpl implements MunicipalityEntityMapper {

    @Autowired
    private StateEntityMapper stateEntityMapper;

    @Override
    public MunicipalityJPAEntity toJPA(MunicipalityEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        StateJPAEntity state = null;

        id = entity.getId();
        name = entity.getName();
        state = stateEntityMapper.toJPA( entity.getState() );

        MunicipalityJPAEntity municipalityJPAEntity = new MunicipalityJPAEntity( id, name, state );

        return municipalityJPAEntity;
    }

    @Override
    public MunicipalityEntity toEntity(MunicipalityJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        MunicipalityEntity municipalityEntity = new MunicipalityEntity();

        return municipalityEntity;
    }

    @Override
    public List<MunicipalityEntity> toEntityList(List<MunicipalityJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<MunicipalityEntity> list = new ArrayList<MunicipalityEntity>( jpaEntities.size() );
        for ( MunicipalityJPAEntity municipalityJPAEntity : jpaEntities ) {
            list.add( toEntity( municipalityJPAEntity ) );
        }

        return list;
    }
}
