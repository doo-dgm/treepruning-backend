package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;

public interface GetProgrammingByFilterUseCase extends UseCase<GetProgrammingDTO, List<GetProgrammingDomain>> {
}
