package co.edu.uco.treepruning.features.manager.createmanager.application.usecase.impl;

import co.edu.uco.treepruning.features.manager.createmanager.application.usecase.CreateManagerUseCase;
import co.edu.uco.treepruning.features.manager.createmanager.application.usecase.domain.CreateManagerDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateManagerUseCaseImpl implements CreateManagerUseCase {

    @Override
    public Void execute(CreateManagerDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
