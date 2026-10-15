package co.edu.uco.treepruning.features.pqr.deletepqr.application.usecase.impl;

import co.edu.uco.treepruning.features.pqr.deletepqr.application.usecase.DeletePQRUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeletePQRUseCaseImpl implements DeletePQRUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
