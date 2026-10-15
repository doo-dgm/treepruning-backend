package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.domain.GetMunicipalityDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetMunicipalityDTOMapper {

    default GetMunicipalityDTO toDTO(GetMunicipalityDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetMunicipalityDTO();
        }
        return new GetMunicipalityDTO(domain.getId(), domain.getName(), domain.getState());
    }
}
