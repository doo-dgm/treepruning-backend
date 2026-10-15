package co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.impl;

import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.ChangePQRStatusUseCase;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.domain.ChangePQRStatusDomain;
import org.springframework.stereotype.Service;

@Service
public class ChangePQRStatusUseCaseImpl implements ChangePQRStatusUseCase {

    @Override
    public Void execute(ChangePQRStatusDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
