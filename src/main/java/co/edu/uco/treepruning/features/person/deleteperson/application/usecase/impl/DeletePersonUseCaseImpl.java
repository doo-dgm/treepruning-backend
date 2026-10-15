package co.edu.uco.treepruning.features.person.deleteperson.application.usecase.impl;

import co.edu.uco.treepruning.features.person.deleteperson.application.usecase.DeletePersonUseCase;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCaseImpl implements DeletePersonUseCase {

    @Override
    public Void execute(UUID id) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
