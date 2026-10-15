package co.edu.uco.treepruning.features.tool.deletetool.application.usecase.impl;

import co.edu.uco.treepruning.features.tool.deletetool.application.usecase.DeleteToolUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteToolUseCaseImpl implements DeleteToolUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
