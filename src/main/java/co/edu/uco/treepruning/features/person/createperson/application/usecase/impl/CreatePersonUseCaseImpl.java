package co.edu.uco.treepruning.features.person.createperson.application.usecase.impl;

import co.edu.uco.treepruning.features.person.createperson.application.usecase.CreatePersonUseCase;
import co.edu.uco.treepruning.features.person.createperson.application.usecase.domain.CreatePersonDomain;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    @Override
    public Void execute(CreatePersonDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
