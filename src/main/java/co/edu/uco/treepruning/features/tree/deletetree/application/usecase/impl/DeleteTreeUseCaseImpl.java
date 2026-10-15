package co.edu.uco.treepruning.features.tree.deletetree.application.usecase.impl;

import co.edu.uco.treepruning.features.tree.deletetree.application.usecase.DeleteTreeUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteTreeUseCaseImpl implements DeleteTreeUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
