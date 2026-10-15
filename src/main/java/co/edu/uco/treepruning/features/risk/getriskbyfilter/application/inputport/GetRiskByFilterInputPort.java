package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import java.util.List;

public interface GetRiskByFilterInputPort extends InputPort<GetRiskDTO, List<GetRiskDTO>> {
}
