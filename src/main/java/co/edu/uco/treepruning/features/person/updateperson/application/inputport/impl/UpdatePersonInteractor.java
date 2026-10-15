package co.edu.uco.treepruning.features.person.updateperson.application.inputport.impl;

import co.edu.uco.treepruning.features.person.updateperson.application.inputport.UpdatePersonInputPort;
import co.edu.uco.treepruning.features.person.updateperson.application.inputport.dto.UpdatePersonDTO;
import co.edu.uco.treepruning.features.person.updateperson.application.usecase.UpdatePersonUseCase;
import co.edu.uco.treepruning.features.person.updateperson.application.usecase.domain.UpdatePersonDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdatePersonInteractor implements UpdatePersonInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdatePersonInteractor.class);

    private final UpdatePersonUseCase useCase;

    public UpdatePersonInteractor(UpdatePersonUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdatePersonDTO data) {
        log.info("UpdatePersonInteractor — recibida solicitud");
        useCase.execute(new UpdatePersonDomain(
                data.getId(),
                data.getFirstName(),
                data.getSecondName(),
                data.getFirstLastName(),
                data.getSecondLastName(),
                data.getDocument(),
                data.getDocumentNumber(),
                data.getBirthDate(),
                data.getAddress(),
                data.getEmail(),
                data.getPhone()));
        return null;
    }
}
