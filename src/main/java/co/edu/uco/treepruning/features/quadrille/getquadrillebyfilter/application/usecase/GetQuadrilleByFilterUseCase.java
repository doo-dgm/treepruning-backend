package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;

public interface GetQuadrilleByFilterUseCase extends UseCase<GetQuadrilleDTO, List<GetQuadrilleDomain>> {
}
