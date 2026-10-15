package co.edu.uco.treepruning.features.person.createperson.application.inputport.impl;

import co.edu.uco.treepruning.features.person.createperson.application.inputport.CreatePersonInputPort;
import co.edu.uco.treepruning.features.person.createperson.application.inputport.dto.CreatePersonDTO;
import co.edu.uco.treepruning.features.person.createperson.application.usecase.CreatePersonUseCase;
import co.edu.uco.treepruning.features.person.createperson.application.usecase.domain.CreatePersonDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreatePersonInteractor implements CreatePersonInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreatePersonInteractor.class);

    private final CreatePersonUseCase useCase;

    public CreatePersonInteractor(CreatePersonUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreatePersonDTO data) {
        log.info("CreatePersonInteractor — recibida solicitud");
        useCase.execute(new CreatePersonDomain(
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
