package co.edu.uco.treepruning.features.administrator.createadministrator.application.usecase.impl;

import co.edu.uco.treepruning.features.administrator.createadministrator.application.usecase.CreateAdministratorUseCase;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.usecase.domain.CreateAdministratorDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateAdministratorUseCaseImpl implements CreateAdministratorUseCase {

    @Override
    public Void execute(CreateAdministratorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
