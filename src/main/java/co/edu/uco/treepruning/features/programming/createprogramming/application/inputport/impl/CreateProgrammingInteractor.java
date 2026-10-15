package co.edu.uco.treepruning.features.programming.createprogramming.application.inputport.impl;

import co.edu.uco.treepruning.features.programming.createprogramming.application.inputport.CreateProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.createprogramming.application.inputport.dto.CreateProgrammingDTO;
import co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.CreateProgrammingUseCase;
import co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.domain.CreateProgrammingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateProgrammingInteractor implements CreateProgrammingInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateProgrammingInteractor.class);

    private final CreateProgrammingUseCase useCase;

    public CreateProgrammingInteractor(CreateProgrammingUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateProgrammingDTO data) {
        log.info("CreateProgrammingInteractor — recibida solicitud");
        useCase.execute(new CreateProgrammingDomain(
                data.getInitialDate(),
                data.getFrequencyMonths(),
                data.getAmount()));
        return null;
    }
}
