package co.edu.uco.treepruning.features.programming.deleteprogramming.application.usecase.impl;

import co.edu.uco.treepruning.features.programming.deleteprogramming.application.usecase.DeleteProgrammingUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteProgrammingUseCaseImpl implements DeleteProgrammingUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
