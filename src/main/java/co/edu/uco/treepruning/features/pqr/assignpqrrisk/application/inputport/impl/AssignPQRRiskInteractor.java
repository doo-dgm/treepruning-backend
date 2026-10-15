package co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.AssignPQRRiskInputPort;
import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.dto.AssignPQRRiskDTO;
import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.usecase.AssignPQRRiskUseCase;
import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.usecase.domain.AssignPQRRiskDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AssignPQRRiskInteractor implements AssignPQRRiskInputPort {

    private static final Logger log = LoggerFactory.getLogger(AssignPQRRiskInteractor.class);

    private final AssignPQRRiskUseCase useCase;

    public AssignPQRRiskInteractor(AssignPQRRiskUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(AssignPQRRiskDTO data) {
        log.info("AssignPQRRiskInteractor — recibida solicitud");
        useCase.execute(new AssignPQRRiskDomain(
                data.getId(),
                data.getRisk()));
        return null;
    }
}
