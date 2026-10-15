package co.edu.uco.treepruning.features.administrator.updateadministrator.application.usecase.impl;

import co.edu.uco.treepruning.features.administrator.updateadministrator.application.usecase.UpdateAdministratorUseCase;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.usecase.domain.UpdateAdministratorDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateAdministratorUseCaseImpl implements UpdateAdministratorUseCase {

    @Override
    public Void execute(UpdateAdministratorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
