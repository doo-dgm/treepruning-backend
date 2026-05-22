package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;

public interface GetTreeByFilterInputPort extends InputPort<GetTreeDTO, List<GetTreeDTO>> {
}
