package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;

public interface GetFamilyByFilterUseCase extends UseCase<GetFamilyDTO, List<GetFamilyDomain>> {
}
