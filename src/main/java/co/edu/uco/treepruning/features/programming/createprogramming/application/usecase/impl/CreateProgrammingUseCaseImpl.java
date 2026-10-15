package co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.impl;

import co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.CreateProgrammingUseCase;
import co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.domain.CreateProgrammingDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateProgrammingUseCaseImpl implements CreateProgrammingUseCase {

    @Override
    public Void execute(CreateProgrammingDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
