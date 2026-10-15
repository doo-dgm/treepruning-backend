package co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.domain.GetStateDomain;
import java.util.List;

public interface GetStateByFilterUseCase extends UseCase<GetStateDTO, List<GetStateDomain>> {
}
