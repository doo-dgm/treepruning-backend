package co.edu.uco.treepruning.features.pruning.gettype.application.usecase.impl;

import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetTypeDomainMapperImpl implements GetTypeDomainMapper {

    @Override
    public GetTypeDomain toDomain(TypeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        GetTypeDomain getTypeDomain = new GetTypeDomain( id, name );

        return getTypeDomain;
    }
}
