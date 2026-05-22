package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;

public interface GetPruningByFilterInputPort extends InputPort<GetPruningDTO, PageResult<GetPruningDTO>> {
}
