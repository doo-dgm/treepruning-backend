package co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.dto.GetPruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.domain.GetPruningToolDomain;
import java.util.List;

public interface GetPruningToolByFilterUseCase extends UseCase<GetPruningToolDTO, List<GetPruningToolDomain>> {
}
