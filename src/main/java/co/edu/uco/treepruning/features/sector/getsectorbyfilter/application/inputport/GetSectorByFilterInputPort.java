package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;

public interface GetSectorByFilterInputPort extends InputPort<GetSectorDTO, List<GetSectorDTO>> {
}
