package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

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

    /** Nombre del tipo en la tabla 'type'. */
    private static final String TYPE_PREVENTIVE = "Preventiva";

    /** Nombre del estado en la tabla 'status'. */
    private static final String STATUS_PLANNED  = "Planeada";

    private final GetTreeByFilterUseCase              getTreeByFilterUseCase;
    private final GetQuadrilleByFilterUseCase         getQuadrilleByFilterUseCase;
    private final GetTypeByFilterUseCase              getTypeByFilterUseCase;
    private final GetStatusByFilterUseCase            getStatusByFilterUseCase;
    private final PruningRepository                   pruningRepository;
    private final SchedulePreventivePruningDomainMapper domainMapper;
    private final ApplicationEventPublisher           eventPublisher;

    public SchedulePreventivePruningUseCaseImpl(
            GetTreeByFilterUseCase              getTreeByFilterUseCase,
            GetQuadrilleByFilterUseCase         getQuadrilleByFilterUseCase,
            GetTypeByFilterUseCase              getTypeByFilterUseCase,
            GetStatusByFilterUseCase            getStatusByFilterUseCase,
            PruningRepository                   pruningRepository,
            SchedulePreventivePruningDomainMapper domainMapper,
            ApplicationEventPublisher           eventPublisher) {
        this.getTreeByFilterUseCase      = getTreeByFilterUseCase;
        this.getQuadrilleByFilterUseCase = getQuadrilleByFilterUseCase;
        this.getTypeByFilterUseCase      = getTypeByFilterUseCase;
        this.getStatusByFilterUseCase    = getStatusByFilterUseCase;
        this.pruningRepository           = pruningRepository;
        this.domainMapper                = domainMapper;
        this.eventPublisher              = eventPublisher;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain domain) {

        // 1. Resolver tipo "Preventiva" desde la BD — no lo envia el cliente
        List<GetTypeDomain> types = getTypeByFilterUseCase.execute(
                new GetTypeDTO(null, TYPE_PREVENTIVE));
        if (types.isEmpty()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.TYPE_PREVENTIVE_NOT_FOUND");
        }
        UUID typeId = types.get(0).getId();

        // 2. Resolver estado "Planeada" desde la BD — no lo envia el cliente
        List<GetStatusDomain> statuses = getStatusByFilterUseCase.execute(
                new GetStatusDTO(null, STATUS_PLANNED));
        if (statuses.isEmpty()) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND",
                    "TECHNICAL.ERROR.PRUNING.STATUS_PLANNED_NOT_FOUND");
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
