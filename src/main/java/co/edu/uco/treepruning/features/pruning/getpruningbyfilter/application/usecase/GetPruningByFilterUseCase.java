package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;

public interface GetPruningByFilterUseCase extends UseCase<GetPruningDTO, PageResult<GetPruningDomain>> {
}
