package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto.GetOperatorDTO;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.domain.GetOperatorDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetOperatorDTOMapper {

    default GetOperatorDTO toDTO(GetOperatorDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetOperatorDTO();
        }
        return new GetOperatorDTO(domain.getId(), domain.getPerson(), domain.getQuadrille());
    }
}
