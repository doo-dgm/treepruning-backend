package co.edu.uco.treepruning.features.pruning.gettype.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain.GetTypeDomain;
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
public class GetTypeDTOMapperImpl implements GetTypeDTOMapper {

    @Override
    public GetTypeDTO toDTO(GetTypeDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = domain.getId();
        name = domain.getName();

        GetTypeDTO getTypeDTO = new GetTypeDTO( id, name );

        return getTypeDTO;
    }

    @Override
    public List<GetTypeDTO> toDTOList(List<GetTypeDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetTypeDTO> list = new ArrayList<GetTypeDTO>( domains.size() );
        for ( GetTypeDomain getTypeDomain : domains ) {
            list.add( toDTO( getTypeDomain ) );
        }

        return list;
    }
}
