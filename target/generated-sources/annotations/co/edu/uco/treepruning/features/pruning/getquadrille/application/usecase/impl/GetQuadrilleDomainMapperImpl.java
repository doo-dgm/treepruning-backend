package co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.impl;

import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetQuadrilleDomainMapperImpl implements GetQuadrilleDomainMapper {

    @Override
    public GetQuadrilleDomain toDomain(QuadrilleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID manager = null;
        UUID id = null;
        String quadrilleName = null;

        manager = entityManagerId( entity );
        id = entity.getId();
        quadrilleName = entity.getQuadrilleName();

        GetQuadrilleDomain getQuadrilleDomain = new GetQuadrilleDomain( id, quadrilleName, manager );

        return getQuadrilleDomain;
    }

    private UUID entityManagerId(QuadrilleEntity quadrilleEntity) {
        if ( quadrilleEntity == null ) {
            return null;
        }
        ManagerEntity manager = quadrilleEntity.getManager();
        if ( manager == null ) {
            return null;
        }
        UUID id = manager.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
