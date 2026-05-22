package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;

public interface GetManagerByFilterInputPort extends InputPort<GetManagerDTO, List<GetManagerDTO>> {
}
