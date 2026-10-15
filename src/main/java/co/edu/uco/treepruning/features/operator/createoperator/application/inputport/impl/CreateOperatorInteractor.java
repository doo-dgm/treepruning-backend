package co.edu.uco.treepruning.features.operator.createoperator.application.inputport.impl;

import co.edu.uco.treepruning.features.operator.createoperator.application.inputport.CreateOperatorInputPort;
import co.edu.uco.treepruning.features.operator.createoperator.application.inputport.dto.CreateOperatorDTO;
import co.edu.uco.treepruning.features.operator.createoperator.application.usecase.CreateOperatorUseCase;
import co.edu.uco.treepruning.features.operator.createoperator.application.usecase.domain.CreateOperatorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateOperatorInteractor implements CreateOperatorInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateOperatorInteractor.class);

    private final CreateOperatorUseCase useCase;

    public CreateOperatorInteractor(CreateOperatorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateOperatorDTO data) {
        log.info("CreateOperatorInteractor — recibida solicitud");
        useCase.execute(new CreateOperatorDomain(
                data.getPerson(),
                data.getQuadrille()));
        return null;
    }
}
