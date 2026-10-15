package co.edu.uco.treepruning.features.programming.updateprogramming.application.inputport.impl;

import co.edu.uco.treepruning.features.programming.updateprogramming.application.inputport.UpdateProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.inputport.dto.UpdateProgrammingDTO;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.UpdateProgrammingUseCase;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.domain.UpdateProgrammingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateProgrammingInteractor implements UpdateProgrammingInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateProgrammingInteractor.class);

    private final UpdateProgrammingUseCase useCase;

    public UpdateProgrammingInteractor(UpdateProgrammingUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateProgrammingDTO data) {
        log.info("UpdateProgrammingInteractor — recibida solicitud");
        useCase.execute(new UpdateProgrammingDomain(
                data.getId(),
                data.getInitialDate(),
                data.getFrequencyMonths(),
                data.getAmount()));
        return null;
    }
}
