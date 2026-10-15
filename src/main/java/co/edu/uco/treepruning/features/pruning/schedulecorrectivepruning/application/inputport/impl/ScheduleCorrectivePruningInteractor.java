package co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.inputport.ScheduleCorrectivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.inputport.dto.ScheduleCorrectivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.usecase.ScheduleCorrectivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.usecase.domain.ScheduleCorrectivePruningDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleCorrectivePruningInteractor implements ScheduleCorrectivePruningInputPort {

    private static final Logger log = LoggerFactory.getLogger(ScheduleCorrectivePruningInteractor.class);

    private final ScheduleCorrectivePruningUseCase useCase;

    public ScheduleCorrectivePruningInteractor(ScheduleCorrectivePruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(ScheduleCorrectivePruningDTO data) {
        log.info("ScheduleCorrectivePruningInteractor — recibida solicitud");
        useCase.execute(new ScheduleCorrectivePruningDomain(
                data.getPqr(),
                data.getTree(),
                data.getPlannedDate(),
                data.getQuadrille(),
                data.getType()));
        return null;
    }
}
