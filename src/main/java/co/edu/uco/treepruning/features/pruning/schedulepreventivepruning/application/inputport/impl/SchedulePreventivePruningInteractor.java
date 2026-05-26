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

    private final SchedulePreventivePruningUseCase useCase;
    private final SchedulePreventivePruningDTOMapper mapper;
    private final ParameterCatalogService parameterCatalog;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase useCase,
            SchedulePreventivePruningDTOMapper mapper,
            ParameterCatalogService parameterCatalog) {
        this.useCase = useCase;
        this.mapper = mapper;
        this.parameterCatalog = parameterCatalog;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
        log.info("SchedulePreventivePruning — received request: tree={}, plannedDate={}, photo={}",
                data.getTree(), data.getPlannedDate(),
                data.getPhotographicRecordPath() != null ? data.getPhotographicRecordPath() : "none");

        // Las fotos se suben previamente via POST /api/v1/photos.
        // El campo photographicRecordPath llega ya con la(s) key(s) de MinIO.

        SchedulePreventivePruningDomain domain = mapper.toDomain(data);
        
        log.info("[SANITIZER] observations after sanitization: '{}'", domain.getObservations());

        log.debug("SchedulePreventivePruning — running validation rules");
        SchedulePreventivePruningDTOValidator.validateStatus(domain.getStatus());

        int horizonMonths = parameterCatalog.getIntValue("podas.horizonte-meses", 12);
        log.debug("SchedulePreventivePruning — horizonte de programación: {} meses (desde Strapi)", horizonMonths);
        SchedulePreventivePruningDTOValidator.validatePlannedDate(domain.getPlannedDate(), horizonMonths);

        SchedulePreventivePruningDTOValidator.validateExecutedDate(domain.getExecutedDate(), domain.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateTree(domain.getTree());
        SchedulePreventivePruningDTOValidator.validateQuadrille(domain.getQuadrille());
        SchedulePreventivePruningDTOValidator.validateType(domain.getType());
        SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(domain.getPhotographicRecordPath());
        SchedulePreventivePruningDTOValidator.validateObservations(domain.getObservations());

        log.debug("SchedulePreventivePruning — validation passed, delegating to use case");
        useCase.execute(domain);

        log.info("SchedulePreventivePruning — pruning scheduled successfully with id={}", domain.getId());
        return null;
    }
}
