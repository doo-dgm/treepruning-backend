package co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.impl;

import co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.UpdateManagerUseCase;
import co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.domain.UpdateManagerDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateManagerUseCaseImpl implements UpdateManagerUseCase {

    @Override
    public Void execute(UpdateManagerDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
