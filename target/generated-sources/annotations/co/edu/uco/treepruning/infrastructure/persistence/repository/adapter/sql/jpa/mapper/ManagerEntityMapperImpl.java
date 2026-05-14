package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-14T12:41:16-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class ManagerEntityMapperImpl implements ManagerEntityMapper {

    @Autowired
    private PersonEntityMapper personEntityMapper;

    @Override
    public ManagerJPAEntity toJPA(ManagerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        PersonJPAEntity person = null;

        id = entity.getId();
        person = personEntityMapper.toJPA( entity.getPerson() );

        ManagerJPAEntity managerJPAEntity = new ManagerJPAEntity( id, person );

        return managerJPAEntity;
    }

    @Override
    public ManagerEntity toEntity(ManagerJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        ManagerEntity managerEntity = new ManagerEntity();

        return managerEntity;
    }

    @Override
    public List<ManagerEntity> toEntityList(List<ManagerJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<ManagerEntity> list = new ArrayList<ManagerEntity>( jpaEntities.size() );
        for ( ManagerJPAEntity managerJPAEntity : jpaEntities ) {
            list.add( toEntity( managerJPAEntity ) );
        }

        return list;
    }
}
