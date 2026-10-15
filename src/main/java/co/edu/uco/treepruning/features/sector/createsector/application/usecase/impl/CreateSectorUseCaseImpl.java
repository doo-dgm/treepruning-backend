package co.edu.uco.treepruning.features.sector.createsector.application.usecase.impl;

import co.edu.uco.treepruning.features.sector.createsector.application.usecase.CreateSectorUseCase;
import co.edu.uco.treepruning.features.sector.createsector.application.usecase.domain.CreateSectorDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateSectorUseCaseImpl implements CreateSectorUseCase {

    @Override
    public Void execute(CreateSectorDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
