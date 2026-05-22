package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;

public interface GetStatusByFilterUseCase extends UseCase<GetStatusDTO, List<GetStatusDomain>> {
}
