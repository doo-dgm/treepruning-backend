package co.edu.uco.treepruning.features.manager.deletemanager.application.usecase.impl;

import co.edu.uco.treepruning.features.manager.deletemanager.application.usecase.DeleteManagerUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteManagerUseCaseImpl implements DeleteManagerUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
