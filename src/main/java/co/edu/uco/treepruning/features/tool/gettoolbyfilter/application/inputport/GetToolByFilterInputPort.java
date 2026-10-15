package co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
import java.util.List;

public interface GetToolByFilterInputPort extends InputPort<GetToolDTO, List<GetToolDTO>> {
}
