package co.edu.uco.treepruning.features.sector.updatesector.application.usecase.impl;

import co.edu.uco.treepruning.features.sector.updatesector.application.usecase.UpdateSectorUseCase;
import co.edu.uco.treepruning.features.sector.updatesector.application.usecase.domain.UpdateSectorDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateSectorUseCaseImpl implements UpdateSectorUseCase {

    @Override
    public Void execute(UpdateSectorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
