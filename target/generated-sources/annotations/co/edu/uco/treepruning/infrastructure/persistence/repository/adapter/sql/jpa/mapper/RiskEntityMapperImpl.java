package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.RiskJPAEntity;
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
public class RiskEntityMapperImpl implements RiskEntityMapper {

    @Override
    public RiskJPAEntity toJPA(RiskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        RiskJPAEntity riskJPAEntity = new RiskJPAEntity( id, name );

        return riskJPAEntity;
    }

    @Override
    public RiskEntity toEntity(RiskJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        RiskEntity riskEntity = new RiskEntity();

        return riskEntity;
    }

    @Override
    public List<RiskEntity> toEntityList(List<RiskJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<RiskEntity> list = new ArrayList<RiskEntity>( jpaEntities.size() );
        for ( RiskJPAEntity riskJPAEntity : jpaEntities ) {
            list.add( toEntity( riskJPAEntity ) );
        }

        return list;
    }
}
