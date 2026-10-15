package co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
import java.util.List;

public interface GetStateByFilterInputPort extends InputPort<GetStateDTO, List<GetStateDTO>> {
}
