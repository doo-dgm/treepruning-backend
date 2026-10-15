package co.edu.uco.treepruning.features.family.updatefamily.application.usecase.impl;

import co.edu.uco.treepruning.features.family.updatefamily.application.usecase.UpdateFamilyUseCase;
import co.edu.uco.treepruning.features.family.updatefamily.application.usecase.domain.UpdateFamilyDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateFamilyUseCaseImpl implements UpdateFamilyUseCase {

    @Override
    public Void execute(UpdateFamilyDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
