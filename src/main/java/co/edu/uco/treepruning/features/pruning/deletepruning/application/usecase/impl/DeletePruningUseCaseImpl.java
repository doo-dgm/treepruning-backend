package co.edu.uco.treepruning.features.pruning.deletepruning.application.usecase.impl;

import co.edu.uco.treepruning.features.pruning.deletepruning.application.usecase.DeletePruningUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeletePruningUseCaseImpl implements DeletePruningUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
