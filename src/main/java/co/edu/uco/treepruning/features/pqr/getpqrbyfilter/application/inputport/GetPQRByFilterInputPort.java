package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import java.util.List;

public interface GetPQRByFilterInputPort extends InputPort<GetPQRDTO, List<GetPQRDTO>> {
}
