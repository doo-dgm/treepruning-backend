package co.edu.uco.treepruning.features.tree.updatetree.application.usecase.impl;

import co.edu.uco.treepruning.features.tree.updatetree.application.usecase.UpdateTreeUseCase;
import co.edu.uco.treepruning.features.tree.updatetree.application.usecase.domain.UpdateTreeDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateTreeUseCaseImpl implements UpdateTreeUseCase {

    @Override
    public Void execute(UpdateTreeDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
