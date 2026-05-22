package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;

@Mapper(componentModel = "spring")
public interface GetManagerDTOMapper {

    default GetManagerDTO toDTO(GetManagerDomain domain) {
        if (ObjectHelper.isNull(domain)) return new GetManagerDTO();
        return new GetManagerDTO(domain.getId(), toPersonDTO(domain.getPerson()));
    }

    default GetPersonDTO toPersonDTO(GetPersonDomain d) {
        if (ObjectHelper.isNull(d)) return new GetPersonDTO();
        return new GetPersonDTO(d.getId(), d.getFirstName(), d.getSecondName(),
                d.getFirstLastName(), d.getSecondLastName(), d.getDocumentNumber(),
                d.getBirthDate(), d.getAddress(), d.getEmail(), d.getPhone(), d.getAge());
    }
}
