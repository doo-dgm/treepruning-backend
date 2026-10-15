package co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.dto.GetAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.domain.GetAdministratorDomain;
import java.util.List;

public interface GetAdministratorByFilterUseCase extends UseCase<GetAdministratorDTO, List<GetAdministratorDomain>> {
}
