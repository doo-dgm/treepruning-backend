package co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.usecase.impl;

import co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.usecase.DeletePruningToolUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeletePruningToolUseCaseImpl implements DeletePruningToolUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
