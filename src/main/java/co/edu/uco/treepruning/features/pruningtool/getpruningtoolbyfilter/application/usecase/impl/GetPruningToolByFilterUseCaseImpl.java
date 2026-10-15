package co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.dto.GetPruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.GetPruningToolByFilterUseCase;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.domain.GetPruningToolDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetPruningToolByFilterUseCaseImpl implements GetPruningToolByFilterUseCase {

    @Override
    public List<GetPruningToolDomain> execute(GetPruningToolDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
