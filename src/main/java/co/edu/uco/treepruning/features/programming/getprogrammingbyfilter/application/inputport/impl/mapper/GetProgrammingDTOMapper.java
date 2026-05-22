package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;

@Mapper(componentModel = "spring")
public interface GetProgrammingDTOMapper {

    default GetProgrammingDTO toDTO(GetProgrammingDomain domain) {
        if (ObjectHelper.isNull(domain)) return new GetProgrammingDTO();
        return new GetProgrammingDTO(domain.getId(), domain.getInitialDate(),
                domain.getFrequencyMonths(), domain.getAmount());
    }
}
