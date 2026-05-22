package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;

public interface GetTreeByFilterUseCase extends UseCase<GetTreeDTO, List<GetTreeDomain>> {
}
