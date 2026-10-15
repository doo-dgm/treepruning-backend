package co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.impl;

import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.RegisterPruningExecutionUseCase;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.domain.RegisterPruningExecutionDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterPruningExecutionUseCaseImpl implements RegisterPruningExecutionUseCase {

    @Override
    public Void execute(RegisterPruningExecutionDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
