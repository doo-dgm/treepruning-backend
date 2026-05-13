package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.mapper.SchedulePreventivePruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulePreventivePruningInteractor
        implements SchedulePreventivePruningInputPort {

    private final SchedulePreventivePruningUseCase useCase;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
        return useCase.execute(
            SchedulePreventivePruningDTOMapper.toDomain(data)
        );
    }
}