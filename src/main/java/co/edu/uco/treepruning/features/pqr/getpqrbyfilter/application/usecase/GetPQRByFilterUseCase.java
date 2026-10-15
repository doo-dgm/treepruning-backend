package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.domain.GetPQRDomain;
import java.util.List;

public interface GetPQRByFilterUseCase extends UseCase<GetPQRDTO, List<GetPQRDomain>> {
}
