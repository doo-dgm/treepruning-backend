package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;

public interface GetPersonByFilterUseCase extends UseCase<GetPersonDTO, List<GetPersonDomain>> {
}
