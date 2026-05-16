package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.CountryJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StateJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class StateEntityMapperImpl implements StateEntityMapper {

    @Override
    public StateJPAEntity toJPA(StateEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        CountryJPAEntity country = null;

        StateJPAEntity stateJPAEntity = new StateJPAEntity( id, name, country );

        return stateJPAEntity;
    }

    @Override
    public StateEntity toEntity(StateJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        StateEntity stateEntity = new StateEntity();

        return stateEntity;
    }

    @Override
    public List<StateEntity> toEntityList(List<StateJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<StateEntity> list = new ArrayList<StateEntity>( jpaEntities.size() );
        for ( StateJPAEntity stateJPAEntity : jpaEntities ) {
            list.add( toEntity( stateJPAEntity ) );
        }

        return list;
    }
}
