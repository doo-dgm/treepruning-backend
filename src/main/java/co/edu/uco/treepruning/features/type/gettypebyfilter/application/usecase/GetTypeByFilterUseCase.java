package co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

public interface GetTypeByFilterUseCase extends UseCase<GetTypeDTO, List<GetTypeDomain>> {
}
