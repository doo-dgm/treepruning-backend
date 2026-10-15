package co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.domain.GetToolDomain;
import java.util.List;

public interface GetToolByFilterUseCase extends UseCase<GetToolDTO, List<GetToolDomain>> {
}
