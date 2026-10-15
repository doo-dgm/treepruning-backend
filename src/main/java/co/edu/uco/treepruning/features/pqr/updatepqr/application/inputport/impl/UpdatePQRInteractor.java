package co.edu.uco.treepruning.features.pqr.updatepqr.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.updatepqr.application.inputport.UpdatePQRInputPort;
import co.edu.uco.treepruning.features.pqr.updatepqr.application.inputport.dto.UpdatePQRDTO;
import co.edu.uco.treepruning.features.pqr.updatepqr.application.usecase.UpdatePQRUseCase;
import co.edu.uco.treepruning.features.pqr.updatepqr.application.usecase.domain.UpdatePQRDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdatePQRInteractor implements UpdatePQRInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdatePQRInteractor.class);

    private final UpdatePQRUseCase useCase;

    public UpdatePQRInteractor(UpdatePQRUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdatePQRDTO data) {
        log.info("UpdatePQRInteractor — recibida solicitud");
        useCase.execute(new UpdatePQRDomain(
                data.getId(),
                data.getDate(),
                data.getStatus(),
                data.getRisk(),
                data.getSector(),
                data.getPerson(),
                data.getPhotographicRecordPath()));
        return null;
    }
}
