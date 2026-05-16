package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.features.pruning.getquadrillebyid.application.usecase.GetQuadrilleByIdUseCase;
import co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase.GetStatusByIdUseCase;
import co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase.GetTreeByIdUseCase;
import co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase.GetTypeByIdUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Service
public class SchedulePreventivePruningUseCaseImpl
        implements SchedulePreventivePruningUseCase {

    private final GetTreeByIdUseCase getTreeByIdUseCase;
    private final GetQuadrilleByIdUseCase getQuadrilleByIdUseCase;
    private final GetTypeByIdUseCase getTypeByIdUseCase;
    private final GetStatusByIdUseCase getStatusByIdUseCase;
    private final PruningRepository pruningRepository;

    public SchedulePreventivePruningUseCaseImpl(
            GetTreeByIdUseCase getTreeByIdUseCase,
            GetQuadrilleByIdUseCase getQuadrilleByIdUseCase,
            GetTypeByIdUseCase getTypeByIdUseCase,
            GetStatusByIdUseCase getStatusByIdUseCase,
            PruningRepository pruningRepository) {
        this.getTreeByIdUseCase = getTreeByIdUseCase;
        this.getQuadrilleByIdUseCase = getQuadrilleByIdUseCase;
        this.getTypeByIdUseCase = getTypeByIdUseCase;
        this.getStatusByIdUseCase = getStatusByIdUseCase;
        this.pruningRepository = pruningRepository;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain data) {

        TreeEntity tree = getTreeByIdUseCase.execute(data.getTree());
        QuadrilleEntity quadrille = getQuadrilleByIdUseCase.execute(data.getQuadrille());
        TypeEntity type = getTypeByIdUseCase.execute(data.getType());
        StatusEntity status = getStatusByIdUseCase.execute(data.getStatus());

        pruningRepository.create(new PruningEntity(
                data.getId(),
                status,
                data.getPlannedDate(),
                data.getExecutedDate(),
                tree,
                quadrille,
                type,
                new PQREntity(),
                data.getPhotographicRecordPath(),
                data.getObservations()));

        return null;
    }
}
