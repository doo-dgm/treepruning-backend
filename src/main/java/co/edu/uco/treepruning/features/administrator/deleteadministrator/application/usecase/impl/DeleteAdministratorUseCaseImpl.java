package co.edu.uco.treepruning.features.administrator.deleteadministrator.application.usecase.impl;

import co.edu.uco.treepruning.features.administrator.deleteadministrator.application.usecase.DeleteAdministratorUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteAdministratorUseCaseImpl implements DeleteAdministratorUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
