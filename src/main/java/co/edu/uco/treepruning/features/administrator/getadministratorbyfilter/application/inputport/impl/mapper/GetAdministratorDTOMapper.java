package co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.dto.GetAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.domain.GetAdministratorDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetAdministratorDTOMapper {

    default GetAdministratorDTO toDTO(GetAdministratorDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetAdministratorDTO();
        }
        return new GetAdministratorDTO(domain.getId(), domain.getUsername(), domain.getEmail(), domain.isEmailConfirmed(), domain.getPhone(), domain.isPhoneConfirmed());
    }
}
