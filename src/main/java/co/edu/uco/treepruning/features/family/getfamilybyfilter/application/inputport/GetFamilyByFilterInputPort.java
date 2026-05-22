package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;

public interface GetFamilyByFilterInputPort extends InputPort<GetFamilyDTO, List<GetFamilyDTO>> {
}
