package co.edu.uco.treepruning.features.sector.deletesector.application.usecase.impl;

import co.edu.uco.treepruning.features.sector.deletesector.application.usecase.DeleteSectorUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteSectorUseCaseImpl implements DeleteSectorUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
