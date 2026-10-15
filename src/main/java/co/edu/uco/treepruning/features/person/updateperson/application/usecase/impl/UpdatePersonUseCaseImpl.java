package co.edu.uco.treepruning.features.person.updateperson.application.usecase.impl;

import co.edu.uco.treepruning.features.person.updateperson.application.usecase.UpdatePersonUseCase;
import co.edu.uco.treepruning.features.person.updateperson.application.usecase.domain.UpdatePersonDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    @Override
    public Void execute(UpdatePersonDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
