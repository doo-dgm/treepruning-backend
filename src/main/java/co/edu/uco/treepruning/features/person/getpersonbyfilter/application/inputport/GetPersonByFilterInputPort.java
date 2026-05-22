package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;

public interface GetPersonByFilterInputPort extends InputPort<GetPersonDTO, List<GetPersonDTO>> {
}
