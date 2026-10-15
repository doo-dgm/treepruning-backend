package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.domain.GetRiskDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetRiskDTOMapper {

    default GetRiskDTO toDTO(GetRiskDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetRiskDTO();
        }
        return new GetRiskDTO(domain.getId(), domain.getName());
    }
}
