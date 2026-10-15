package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.domain.GetRiskDomain;
import java.util.List;

public interface GetRiskByFilterUseCase extends UseCase<GetRiskDTO, List<GetRiskDomain>> {
}
