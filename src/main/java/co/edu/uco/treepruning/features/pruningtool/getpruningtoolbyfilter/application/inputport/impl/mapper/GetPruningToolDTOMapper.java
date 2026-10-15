package co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.impl.mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.dto.GetPruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.domain.GetPruningToolDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetPruningToolDTOMapper {

    default GetPruningToolDTO toDTO(GetPruningToolDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetPruningToolDTO();
        }
        return new GetPruningToolDTO(domain.getId(), domain.getPruning(), domain.getTool());
    }
}
