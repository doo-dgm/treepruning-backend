package co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.SubmitPQRInputPort;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto.SubmitPQRDTO;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.SubmitPQRUseCase;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.domain.SubmitPQRDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class SubmitPQRInteractor implements SubmitPQRInputPort {

    private static final Logger log = LoggerFactory.getLogger(SubmitPQRInteractor.class);

    private final SubmitPQRUseCase submitPQRUseCase;

    public SubmitPQRInteractor(SubmitPQRUseCase submitPQRUseCase) {
        this.submitPQRUseCase = submitPQRUseCase;
    }

    @Override
    public Void execute(SubmitPQRDTO data) {
        log.info("SubmitPQR — received request: sector={}, person={}, date={}",
                data.getSector(), data.getPerson(), data.getDate());

        SubmitPQRDomain domain = new SubmitPQRDomain(
                data.getDate(),
                data.getStatus(),
                data.getSector(),
                data.getRisk(),
                data.getPerson(),
                data.getPhotographicRecordPath());

        log.debug("SubmitPQR — delegating to use case");
        submitPQRUseCase.execute(domain);

        log.info("SubmitPQR — completed for id={}", domain.getId());
        return null;
    }
}
