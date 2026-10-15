package co.edu.uco.treepruning.features.tool.createtool.application.usecase.impl;

import co.edu.uco.treepruning.features.tool.createtool.application.usecase.CreateToolUseCase;
import co.edu.uco.treepruning.features.tool.createtool.application.usecase.domain.CreateToolDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateToolUseCaseImpl implements CreateToolUseCase {

    @Override
    public Void execute(CreateToolDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
