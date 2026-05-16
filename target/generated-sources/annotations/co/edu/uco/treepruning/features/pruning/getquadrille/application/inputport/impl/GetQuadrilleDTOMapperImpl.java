package co.edu.uco.treepruning.features.pruning.getquadrille.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.getquadrille.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain.GetQuadrilleDomain;
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
public class GetQuadrilleDTOMapperImpl implements GetQuadrilleDTOMapper {

    @Override
    public GetQuadrilleDTO toDTO(GetQuadrilleDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String quadrilleName = null;
        UUID manager = null;

        id = domain.getId();
        quadrilleName = domain.getQuadrilleName();
        manager = domain.getManager();

        GetQuadrilleDTO getQuadrilleDTO = new GetQuadrilleDTO( id, quadrilleName, manager );

        return getQuadrilleDTO;
    }

    @Override
    public List<GetQuadrilleDTO> toDTOList(List<GetQuadrilleDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetQuadrilleDTO> list = new ArrayList<GetQuadrilleDTO>( domains.size() );
        for ( GetQuadrilleDomain getQuadrilleDomain : domains ) {
            list.add( toDTO( getQuadrilleDomain ) );
        }

        return list;
    }
}
