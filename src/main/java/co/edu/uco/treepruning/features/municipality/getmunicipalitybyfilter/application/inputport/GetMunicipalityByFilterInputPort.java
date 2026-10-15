package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import java.util.List;

public interface GetMunicipalityByFilterInputPort extends InputPort<GetMunicipalityDTO, List<GetMunicipalityDTO>> {
}
