package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto.GetOperatorDTO;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.domain.GetOperatorDomain;
import java.util.List;

public interface GetOperatorByFilterUseCase extends UseCase<GetOperatorDTO, List<GetOperatorDomain>> {
}
