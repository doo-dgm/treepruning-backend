package co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.domain.GetStatusDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T00:07:07-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetStatusDTOMapperImpl implements GetStatusDTOMapper {

    @Override
    public GetStatusDTO toDTO(GetStatusDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = domain.getId();
        name = domain.getName();

        GetStatusDTO getStatusDTO = new GetStatusDTO( id, name );

        return getStatusDTO;
    }

    @Override
    public List<GetStatusDTO> toDTOList(List<GetStatusDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetStatusDTO> list = new ArrayList<GetStatusDTO>( domains.size() );
        for ( GetStatusDomain getStatusDomain : domains ) {
            list.add( toDTO( getStatusDomain ) );
        }

        return list;
    }
}
