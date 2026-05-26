package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import java.util.List;
import java.util.UUID;

import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.crosscutting.config.ParameterCatalogService;
import co.edu.uco.treepruning.crosscutting.event.PruningScheduledEvent;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl.mapper.SchedulePreventivePruningDomainMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.QuadrilleNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeAlreadyScheduledForDateException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeNotFoundForPruningException;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.GetQuadrilleByFilterUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.GetStatusByFilterUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.GetTreeByFilterUseCase;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.GetTypeByFilterUseCase;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;

@Service
public class SchedulePreventivePruningUseCaseImpl
        implements SchedulePreventivePruningUseCase {

    // Claves en Strapi (coleccion 'parametro'). El valor es el nombre exacto
    // de la fila en las tablas 'type' / 'status' de la BD. Si el parametro no
    // existe en Strapi, se lanza la excepcion correspondiente (no hay fallback
    // hardcoded para evitar que un cambio en BD/CMS quede invisible).
    private static final String PARAM_TYPE_PREVENTIVE = "podas.tipo-creacion-preventiva";
    private static final String PARAM_STATUS_PLANNED  = "podas.estado-creacion-default";

    private final GetTreeByFilterUseCase              getTreeByFilterUseCase;
    private final GetQuadrilleByFilterUseCase         getQuadrilleByFilterUseCase;
    private final GetTypeByFilterUseCase              getTypeByFilterUseCase;
    private final GetStatusByFilterUseCase            getStatusByFilterUseCase;
    private final PruningRepository                   pruningRepository;
    private final SchedulePreventivePruningDomainMapper domainMapper;
    private final ApplicationEventPublisher           eventPublisher;
    private final ParameterCatalogService             parameterCatalog;

    public SchedulePreventivePruningUseCaseImpl(
            GetTreeByFilterUseCase              getTreeByFilterUseCase,
            GetQuadrilleByFilterUseCase         getQuadrilleByFilterUseCase,
            GetTypeByFilterUseCase              getTypeByFilterUseCase,
            GetStatusByFilterUseCase            getStatusByFilterUseCase,
            PruningRepository                   pruningRepository,
            SchedulePreventivePruningDomainMapper domainMapper,
            ApplicationEventPublisher           eventPublisher,
            ParameterCatalogService             parameterCatalog) {
        this.getTreeByFilterUseCase      = getTreeByFilterUseCase;
        this.getQuadrilleByFilterUseCase = getQuadrilleByFilterUseCase;
        this.getTypeByFilterUseCase      = getTypeByFilterUseCase;
        this.getStatusByFilterUseCase    = getStatusByFilterUseCase;
        this.pruningRepository           = pruningRepository;
        this.domainMapper                = domainMapper;
        this.eventPublisher              = eventPublisher;
        this.parameterCatalog            = parameterCatalog;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain domain) {

        // 1. Resolver nombre del tipo desde Strapi (parametro configurable),
        //    luego buscar el UUID en la tabla 'type' por ese nombre.
        String typeName = parameterCatalog.getValue(PARAM_TYPE_PREVENTIVE);
        if (typeName == null || typeName.isBlank()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND",
                    Map.of("parameterKey", PARAM_TYPE_PREVENTIVE));
        }
        List<GetTypeDomain> types = getTypeByFilterUseCase.execute(
                new GetTypeDTO(null, typeName));
        if (types.isEmpty()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND",
                    Map.of("typeName", typeName, "parameterKey", PARAM_TYPE_PREVENTIVE));
        }
        UUID typeId = types.get(0).getId();

        // 2. Resolver nombre del estado desde Strapi, idem.
        String statusName = parameterCatalog.getValue(PARAM_STATUS_PLANNED);
        if (statusName == null || statusName.isBlank()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND",
                    Map.of("parameterKey", PARAM_STATUS_PLANNED));
        }
        List<GetStatusDomain> statuses = getStatusByFilterUseCase.execute(
                new GetStatusDTO(null, statusName));
        if (statuses.isEmpty()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND",
                    Map.of("statusName", statusName, "parameterKey", PARAM_STATUS_PLANNED));
        }
        UUID statusId = statuses.get(0).getId();

        // 3. Validar que la cuadrilla existe
        if (getQuadrilleByFilterUseCase.execute(
                new GetQuadrilleDTO(domain.getQuadrille())).isEmpty()) {
            throw QuadrilleNotFoundForPruningException.create(domain.getQuadrille());
        }

        // 4. Crear una poda preventiva por cada arbol
        for (UUID treeId : domain.getTrees()) {

            if (getTreeByFilterUseCase.execute(new GetTreeDTO(treeId)).isEmpty()) {
                throw TreeNotFoundForPruningException.create(treeId);
            }

            if (pruningRepository.existsByTreeAndPlannedDate(treeId, domain.getPlannedDate())) {
                throw TreeAlreadyScheduledForDateException.create(treeId, domain.getPlannedDate());
            }

            // Construir domain por-arbol con todos los IDs resueltos
            SchedulePreventivePruningDomain perTreeDomain = new SchedulePreventivePruningDomain(
                    statusId,
                    domain.getPlannedDate(),
                    null,   // executedDate: todavia no se ha ejecutado
                    treeId,
                    domain.getQuadrille(),
                    typeId,
                    domain.getPhotographicRecordPath(),
                    domain.getObservations());

            pruningRepository.create(domainMapper.toEntity(perTreeDomain));
            eventPublisher.publishEvent(
                    new PruningScheduledEvent(
                            perTreeDomain.getId(), treeId, domain.getPlannedDate()));
        }

        return null;
    }
}
