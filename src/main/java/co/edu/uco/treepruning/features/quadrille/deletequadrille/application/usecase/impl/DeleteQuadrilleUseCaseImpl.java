package co.edu.uco.treepruning.features.quadrille.deletequadrille.application.usecase.impl;

import co.edu.uco.treepruning.features.quadrille.deletequadrille.application.usecase.DeleteQuadrilleUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteQuadrilleUseCaseImpl implements DeleteQuadrilleUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
