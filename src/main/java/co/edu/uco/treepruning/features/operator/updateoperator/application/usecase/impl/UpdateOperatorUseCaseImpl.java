package co.edu.uco.treepruning.features.operator.updateoperator.application.usecase.impl;

import co.edu.uco.treepruning.features.operator.updateoperator.application.usecase.UpdateOperatorUseCase;
import co.edu.uco.treepruning.features.operator.updateoperator.application.usecase.domain.UpdateOperatorDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateOperatorUseCaseImpl implements UpdateOperatorUseCase {

    @Override
    public Void execute(UpdateOperatorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
