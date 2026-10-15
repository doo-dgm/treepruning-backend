package co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.ChangePQRStatusInputPort;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.dto.ChangePQRStatusDTO;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.ChangePQRStatusUseCase;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.domain.ChangePQRStatusDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChangePQRStatusInteractor implements ChangePQRStatusInputPort {

    private static final Logger log = LoggerFactory.getLogger(ChangePQRStatusInteractor.class);

    private final ChangePQRStatusUseCase useCase;

    public ChangePQRStatusInteractor(ChangePQRStatusUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(ChangePQRStatusDTO data) {
        log.info("ChangePQRStatusInteractor — recibida solicitud");
        useCase.execute(new ChangePQRStatusDomain(
                data.getId(),
                data.getStatus()));
        return null;
    }
}
