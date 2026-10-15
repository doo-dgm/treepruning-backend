package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto.GetOperatorDTO;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.GetOperatorByFilterUseCase;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.domain.GetOperatorDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetOperatorByFilterUseCaseImpl implements GetOperatorByFilterUseCase {

    @Override
    public List<GetOperatorDomain> execute(GetOperatorDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
