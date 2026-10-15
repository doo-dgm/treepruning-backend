package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.domain.GetDocumentDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetDocumentDTOMapper {

    default GetDocumentDTO toDTO(GetDocumentDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetDocumentDTO();
        }
        return new GetDocumentDTO(domain.getId(), domain.getName(), domain.getCode());
    }
}
