package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.domain.GetPQRDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetPQRDTOMapper {

    default GetPQRDTO toDTO(GetPQRDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetPQRDTO();
        }
        return new GetPQRDTO(domain.getId(), domain.getDate(), domain.getStatus(), domain.getRisk(), domain.getSector(), domain.getPerson(), domain.getPhotographicRecordPath());
    }
}
