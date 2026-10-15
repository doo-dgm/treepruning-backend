package co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.domain.GetStateDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetStateDTOMapper {

    default GetStateDTO toDTO(GetStateDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetStateDTO();
        }
        return new GetStateDTO(domain.getId(), domain.getName(), domain.getCountry());
    }
}
