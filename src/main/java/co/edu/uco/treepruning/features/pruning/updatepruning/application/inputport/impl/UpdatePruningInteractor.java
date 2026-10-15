package co.edu.uco.treepruning.features.pruning.updatepruning.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.updatepruning.application.inputport.UpdatePruningInputPort;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.inputport.dto.UpdatePruningDTO;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.UpdatePruningUseCase;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.domain.UpdatePruningDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdatePruningInteractor implements UpdatePruningInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdatePruningInteractor.class);

    private final UpdatePruningUseCase useCase;

    public UpdatePruningInteractor(UpdatePruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdatePruningDTO data) {
        log.info("UpdatePruningInteractor — recibida solicitud");
        useCase.execute(new UpdatePruningDomain(
                data.getId(),
                data.getStatus(),
                data.getPlannedDate(),
                data.getExecutedDate(),
                data.getTree(),
                data.getQuadrille(),
                data.getType(),
                data.getPqr(),
                data.getPhotographicRecordPath(),
                data.getObservations()));
        return null;
    }
}
