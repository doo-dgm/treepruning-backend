package co.edu.uco.treepruning.features.operator.createoperator.application.usecase.impl;

import co.edu.uco.treepruning.features.operator.createoperator.application.usecase.CreateOperatorUseCase;
import co.edu.uco.treepruning.features.operator.createoperator.application.usecase.domain.CreateOperatorDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateOperatorUseCaseImpl implements CreateOperatorUseCase {

    @Override
    public Void execute(CreateOperatorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
