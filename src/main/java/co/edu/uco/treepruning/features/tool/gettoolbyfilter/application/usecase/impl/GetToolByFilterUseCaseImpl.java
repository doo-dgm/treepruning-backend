package co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.GetToolByFilterUseCase;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.domain.GetToolDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetToolByFilterUseCaseImpl implements GetToolByFilterUseCase {

    @Override
    public List<GetToolDomain> execute(GetToolDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
