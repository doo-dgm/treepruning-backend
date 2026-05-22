package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;

public interface GetStatusByFilterInputPort extends InputPort<GetStatusDTO, List<GetStatusDTO>> {
}
