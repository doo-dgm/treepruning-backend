package co.edu.uco.treepruning.features.operator.updateoperator.application.inputport.impl;

import co.edu.uco.treepruning.features.operator.updateoperator.application.inputport.UpdateOperatorInputPort;
import co.edu.uco.treepruning.features.operator.updateoperator.application.inputport.dto.UpdateOperatorDTO;
import co.edu.uco.treepruning.features.operator.updateoperator.application.usecase.UpdateOperatorUseCase;
import co.edu.uco.treepruning.features.operator.updateoperator.application.usecase.domain.UpdateOperatorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateOperatorInteractor implements UpdateOperatorInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateOperatorInteractor.class);

    private final UpdateOperatorUseCase useCase;

    public UpdateOperatorInteractor(UpdateOperatorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateOperatorDTO data) {
        log.info("UpdateOperatorInteractor — recibida solicitud");
        useCase.execute(new UpdateOperatorDomain(
                data.getId(),
                data.getPerson(),
                data.getQuadrille()));
        return null;
    }
}
