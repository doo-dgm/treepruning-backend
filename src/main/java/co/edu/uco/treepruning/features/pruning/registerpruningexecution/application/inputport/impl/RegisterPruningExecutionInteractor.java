package co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.inputport.RegisterPruningExecutionInputPort;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.inputport.dto.RegisterPruningExecutionDTO;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.RegisterPruningExecutionUseCase;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.domain.RegisterPruningExecutionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterPruningExecutionInteractor implements RegisterPruningExecutionInputPort {

    private static final Logger log = LoggerFactory.getLogger(RegisterPruningExecutionInteractor.class);

    private final RegisterPruningExecutionUseCase useCase;

    public RegisterPruningExecutionInteractor(RegisterPruningExecutionUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(RegisterPruningExecutionDTO data) {
        log.info("RegisterPruningExecutionInteractor — recibida solicitud");
        useCase.execute(new RegisterPruningExecutionDomain(
                data.getId(),
                data.getExecutedDate(),
                data.getPhotographicRecordPath(),
                data.getObservations()));
        return null;
    }
}
