package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

public interface GetTypeByFilterInputPort extends InputPort<GetTypeDTO, List<GetTypeDTO>> {
}
