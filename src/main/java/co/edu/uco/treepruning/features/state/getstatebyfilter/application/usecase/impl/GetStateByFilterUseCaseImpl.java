package co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.GetStateByFilterUseCase;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.domain.GetStateDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetStateByFilterUseCaseImpl implements GetStateByFilterUseCase {

    @Override
    public List<GetStateDomain> execute(GetStateDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
