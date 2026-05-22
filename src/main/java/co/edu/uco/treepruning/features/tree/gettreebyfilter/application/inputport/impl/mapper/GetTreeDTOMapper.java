package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;

@Mapper(componentModel = "spring")
public interface GetTreeDTOMapper {

    default GetTreeDTO toDTO(GetTreeDomain domain) {
        if (ObjectHelper.isNull(domain)) return new GetTreeDTO();
        return new GetTreeDTO(domain.getId(), domain.getLongitude(), domain.getLatitude(),
                toFamilyDTO(domain.getFamily()), toSectorDTO(domain.getSector()), toProgrammingDTO(domain.getProgramming()));
    }

    default GetFamilyDTO toFamilyDTO(GetFamilyDomain d) {
        if (ObjectHelper.isNull(d)) return new GetFamilyDTO();
        return new GetFamilyDTO(d.getId(), d.getCommonName(), d.getScientificName());
    }

    default GetSectorDTO toSectorDTO(GetSectorDomain d) {
        if (ObjectHelper.isNull(d)) return new GetSectorDTO();
        return new GetSectorDTO(d.getId(), d.getName());
    }

    default GetProgrammingDTO toProgrammingDTO(GetProgrammingDomain d) {
        if (ObjectHelper.isNull(d)) return new GetProgrammingDTO();
        return new GetProgrammingDTO(d.getId(), d.getInitialDate(), d.getFrequencyMonths(), d.getAmount());
    }
}
