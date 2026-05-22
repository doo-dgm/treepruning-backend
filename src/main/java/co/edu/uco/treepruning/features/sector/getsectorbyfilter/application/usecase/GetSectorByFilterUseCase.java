package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;

public interface GetSectorByFilterUseCase extends UseCase<GetSectorDTO, List<GetSectorDomain>> {
}
