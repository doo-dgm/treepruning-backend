package co.edu.uco.treepruning.features.family.createfamily.application.usecase.impl;

import co.edu.uco.treepruning.features.family.createfamily.application.usecase.CreateFamilyUseCase;
import co.edu.uco.treepruning.features.family.createfamily.application.usecase.domain.CreateFamilyDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateFamilyUseCaseImpl implements CreateFamilyUseCase {

    @Override
    public Void execute(CreateFamilyDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
