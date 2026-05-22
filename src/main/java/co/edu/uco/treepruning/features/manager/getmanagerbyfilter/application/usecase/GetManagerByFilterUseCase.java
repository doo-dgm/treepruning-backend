package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;

public interface GetManagerByFilterUseCase extends UseCase<GetManagerDTO, List<GetManagerDomain>> {
}
