package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.crosscutting.config.ParameterCatalogService;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator.SchedulePreventivePruningDTOValidator;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl.mapper.SchedulePreventivePruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulePreventivePruningInteractor implements SchedulePreventivePruningInputPort {

    private static final Logger log = LoggerFactory.getLogger(SchedulePreventivePruningInteractor.class);

    private final SchedulePreventivePruningUseCase     useCase;
    private final SchedulePreventivePruningDTOMapper   mapper;
    private final ParameterCatalogService              parameterCatalog;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase   useCase,
            SchedulePreventivePruningDTOMapper mapper,
            ParameterCatalogService            parameterCatalog) {
        this.useCase          = useCase;
        this.mapper           = mapper;
        this.parameterCatalog = parameterCatalog;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
        log.info("SchedulePreventivePruning — received request: trees={}, plannedDate={}, photo={}",
                data.getTrees().size(),
                data.getPlannedDate(),
                data.getPhotographicRecordPath() != null ? data.getPhotographicRecordPath() : "none");

        log.debug("SchedulePreventivePruning — running validation rules");
        SchedulePreventivePruningDTOValidator.validateTrees(data.getTrees());

        int horizonMonths = parameterCatalog.getIntValue("podas.horizonte-meses", 12);
        log.debug("SchedulePreventivePruning — horizonte de programacion: {} meses (desde Strapi)", horizonMonths);
        SchedulePreventivePruningDTOValidator.validatePlannedDate(data.getPlannedDate(), horizonMonths);

        SchedulePreventivePruningDTOValidator.validateQuadrille(data.getQuadrille());
        SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(data.getPhotographicRecordPath());

        log.debug("SchedulePreventivePruning — validation passed, mapping to domain");
        SchedulePreventivePruningDomain domain = mapper.toDomain(data);

        log.debug("SchedulePreventivePruning — delegating to use case");
        useCase.execute(domain);

        log.info("SchedulePreventivePruning — {} poda(s) preventiva(s) programada(s) exitosamente",
                domain.getTrees().size());
        return null;
    }
}
