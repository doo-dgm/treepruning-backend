package co.edu.uco.treepruning.features.operator.deleteoperator.application.usecase.impl;

import co.edu.uco.treepruning.features.operator.deleteoperator.application.usecase.DeleteOperatorUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteOperatorUseCaseImpl implements DeleteOperatorUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
