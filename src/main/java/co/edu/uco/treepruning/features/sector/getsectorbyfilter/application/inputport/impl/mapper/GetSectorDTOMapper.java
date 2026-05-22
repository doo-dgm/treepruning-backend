package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;

@Mapper(componentModel = "spring")
public interface GetSectorDTOMapper {

    default GetSectorDTO toDTO(GetSectorDomain domain) {
        if (ObjectHelper.isNull(domain)) return new GetSectorDTO();
        return new GetSectorDTO(domain.getId(), domain.getName());
    }
}
