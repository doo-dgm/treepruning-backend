package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator.SchedulePreventivePruningDTOValidator;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.mapper.SchedulePreventivePruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulePreventivePruningInteractor
        implements SchedulePreventivePruningInputPort {

    private final SchedulePreventivePruningUseCase useCase;
    private final SchedulePreventivePruningDTOMapper mapper;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase useCase,
            SchedulePreventivePruningDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
        SchedulePreventivePruningDTOValidator.validateStatus(data.getStatus());
        SchedulePreventivePruningDTOValidator.validatePlannedDate(data.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateExecutedDate(data.getExecutedDate(), data.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateTree(data.getTree());
        SchedulePreventivePruningDTOValidator.validateQuadrille(data.getQuadrille());
        SchedulePreventivePruningDTOValidator.validateType(data.getType());
        SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(data.getPhotographicRecordPath());
        SchedulePreventivePruningDTOValidator.validateObservations(data.getObservations());
        return useCase.execute(mapper.toDomain(data));
    }
}
