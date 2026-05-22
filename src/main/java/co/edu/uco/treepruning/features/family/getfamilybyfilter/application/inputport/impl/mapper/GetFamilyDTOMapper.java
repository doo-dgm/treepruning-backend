package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;

@Mapper(componentModel = "spring")
public interface GetFamilyDTOMapper {

    default GetFamilyDTO toDTO(GetFamilyDomain domain) {
        if (ObjectHelper.isNull(domain)) return new GetFamilyDTO();
        return new GetFamilyDTO(domain.getId(), domain.getCommonName(), domain.getScientificName());
    }
}
