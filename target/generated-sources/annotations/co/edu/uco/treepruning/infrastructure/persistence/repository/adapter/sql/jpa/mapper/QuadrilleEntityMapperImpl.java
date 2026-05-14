package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;
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
public class QuadrilleEntityMapperImpl implements QuadrilleEntityMapper {

    @Autowired
    private ManagerEntityMapper managerEntityMapper;

    @Override
    public QuadrilleJPAEntity toJPA(QuadrilleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String quadrilleName = null;
        ManagerJPAEntity manager = null;

        id = entity.getId();
        quadrilleName = entity.getQuadrilleName();
        manager = managerEntityMapper.toJPA( entity.getManager() );

        QuadrilleJPAEntity quadrilleJPAEntity = new QuadrilleJPAEntity( id, quadrilleName, manager );

        return quadrilleJPAEntity;
    }

    @Override
    public QuadrilleEntity toEntity(QuadrilleJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        QuadrilleEntity quadrilleEntity = new QuadrilleEntity();

        return quadrilleEntity;
    }

    @Override
    public List<QuadrilleEntity> toEntityList(List<QuadrilleJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<QuadrilleEntity> list = new ArrayList<QuadrilleEntity>( jpaEntities.size() );
        for ( QuadrilleJPAEntity quadrilleJPAEntity : jpaEntities ) {
            list.add( toEntity( quadrilleJPAEntity ) );
        }

        return list;
    }
}
