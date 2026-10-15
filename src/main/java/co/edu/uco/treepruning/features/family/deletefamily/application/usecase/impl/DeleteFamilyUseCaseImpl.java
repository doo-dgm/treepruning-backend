package co.edu.uco.treepruning.features.family.deletefamily.application.usecase.impl;

import co.edu.uco.treepruning.features.family.deletefamily.application.usecase.DeleteFamilyUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteFamilyUseCaseImpl implements DeleteFamilyUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
