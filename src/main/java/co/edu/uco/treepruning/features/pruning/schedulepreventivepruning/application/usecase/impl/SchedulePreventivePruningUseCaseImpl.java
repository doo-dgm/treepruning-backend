package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.GetQuadrilleByFilterUseCase;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.GetStatusByFilterUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.GetTreeByFilterUseCase;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.GetTypeByFilterUseCase;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl.mapper.SchedulePreventivePruningDomainMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.QuadrilleNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.StatusNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PruningTypeNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeAlreadyScheduledForDateException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeNotFoundForPruningException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;

@Service
public class SchedulePreventivePruningUseCaseImpl
        implements SchedulePreventivePruningUseCase {

    private final GetTreeByFilterUseCase getTreeByFilterUseCase;
    private final GetQuadrilleByFilterUseCase getQuadrilleByFilterUseCase;
    private final GetTypeByFilterUseCase getTypeByFilterUseCase;
    private final GetStatusByFilterUseCase getStatusByFilterUseCase;
    private final PruningRepository pruningRepository;
    private final SchedulePreventivePruningDomainMapper domainMapper;

    public SchedulePreventivePruningUseCaseImpl(
            GetTreeByFilterUseCase getTreeByFilterUseCase,
            GetQuadrilleByFilterUseCase getQuadrilleByFilterUseCase,
            GetTypeByFilterUseCase getTypeByFilterUseCase,
            GetStatusByFilterUseCase getStatusByFilterUseCase,
            PruningRepository pruningRepository,
            SchedulePreventivePruningDomainMapper domainMapper) {
        this.getTreeByFilterUseCase = getTreeByFilterUseCase;
        this.getQuadrilleByFilterUseCase = getQuadrilleByFilterUseCase;
        this.getTypeByFilterUseCase = getTypeByFilterUseCase;
        this.getStatusByFilterUseCase = getStatusByFilterUseCase;
        this.pruningRepository = pruningRepository;
        this.domainMapper = domainMapper;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain data) {
        List<GetTreeDomain> trees = getTreeByFilterUseCase.execute(new GetTreeDTO(data.getTree()));
        if (trees.isEmpty()) {
            throw TreeNotFoundForPruningException.create(data.getTree());
        }

        List<GetQuadrilleDomain> quadrilles = getQuadrilleByFilterUseCase.execute(new GetQuadrilleDTO(data.getQuadrille()));
        if (quadrilles.isEmpty()) {
            throw QuadrilleNotFoundForPruningException.create(data.getQuadrille());
        }

        List<GetTypeDomain> types = getTypeByFilterUseCase.execute(new GetTypeDTO(data.getType()));
        if (types.isEmpty()) {
            throw PruningTypeNotFoundForPruningException.create(data.getType());
        }

        List<GetStatusDomain> statuses = getStatusByFilterUseCase.execute(new GetStatusDTO(data.getStatus()));
        if (statuses.isEmpty()) {
            throw StatusNotFoundForPruningException.create(data.getStatus());
        }

        if (pruningRepository.existsByTreeAndPlannedDate(
                data.getTree(), data.getPlannedDate())) {
            throw TreeAlreadyScheduledForDateException.create(
                    data.getTree(), data.getPlannedDate());
        }

        pruningRepository.create(domainMapper.toEntity(data));

        return null;
    }
}
