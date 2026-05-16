package co.edu.uco.treepruning.features.pruning.gettree.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.pruning.gettree.application.usecase.domain.GetTreeDomain;
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
public class GetTreeDTOMapperImpl implements GetTreeDTOMapper {

    @Override
    public GetTreeDTO toDTO(GetTreeDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String longitude = null;
        String latitude = null;
        UUID family = null;
        UUID sector = null;
        UUID programming = null;

        id = domain.getId();
        longitude = domain.getLongitude();
        latitude = domain.getLatitude();
        family = domain.getFamily();
        sector = domain.getSector();
        programming = domain.getProgramming();

        GetTreeDTO getTreeDTO = new GetTreeDTO( id, longitude, latitude, family, sector, programming );

        return getTreeDTO;
    }

    @Override
    public List<GetTreeDTO> toDTOList(List<GetTreeDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetTreeDTO> list = new ArrayList<GetTreeDTO>( domains.size() );
        for ( GetTreeDomain getTreeDomain : domains ) {
            list.add( toDTO( getTreeDomain ) );
        }

        return list;
    }
}
