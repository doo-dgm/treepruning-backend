package co.edu.uco.treepruning.features.tree.createtree.application.usecase.impl;

import co.edu.uco.treepruning.features.tree.createtree.application.usecase.CreateTreeUseCase;
import co.edu.uco.treepruning.features.tree.createtree.application.usecase.domain.CreateTreeDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateTreeUseCaseImpl implements CreateTreeUseCase {

    @Override
    public Void execute(CreateTreeDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
