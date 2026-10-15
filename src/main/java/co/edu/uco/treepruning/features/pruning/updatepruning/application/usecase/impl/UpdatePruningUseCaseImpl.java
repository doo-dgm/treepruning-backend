package co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.impl;

import co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.UpdatePruningUseCase;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.domain.UpdatePruningDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdatePruningUseCaseImpl implements UpdatePruningUseCase {

    @Override
    public Void execute(UpdatePruningDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
