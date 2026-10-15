package co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.domain.GetToolDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetToolDTOMapper {

    default GetToolDTO toDTO(GetToolDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetToolDTO();
        }
        return new GetToolDTO(domain.getId(), domain.getName(), domain.getDescription());
    }
}
