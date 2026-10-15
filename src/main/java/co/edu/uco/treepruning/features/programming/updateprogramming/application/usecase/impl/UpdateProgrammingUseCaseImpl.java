package co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.impl;

import co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.UpdateProgrammingUseCase;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.domain.UpdateProgrammingDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateProgrammingUseCaseImpl implements UpdateProgrammingUseCase {

    @Override
    public Void execute(UpdateProgrammingDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
