package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PruningTypeNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.QuadrilleNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.StatusNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeNotFoundForPruningException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PQREntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Service
public class SchedulePreventivePruningUseCaseImpl
        implements SchedulePreventivePruningUseCase {

    private final PruningRepository pruningRepository;
    private final TreeRepository treeRepository;
    private final QuadrilleRepository quadrilleRepository;
    private final TypeRepository typeRepository;
    private final StatusRepository statusRepository;

    public SchedulePreventivePruningUseCaseImpl(
            PruningRepository pruningRepository,
            TreeRepository treeRepository,
            QuadrilleRepository quadrilleRepository,
            TypeRepository typeRepository,
            StatusRepository statusRepository) {
        this.pruningRepository = pruningRepository;
        this.treeRepository = treeRepository;
        this.quadrilleRepository = quadrilleRepository;
        this.typeRepository = typeRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain data) {

        TreeEntity tree = treeRepository.findById(data.getTree());
        if (tree == null) {
            throw TreeNotFoundForPruningException.create(data.getTree());
        }

        QuadrilleEntity quadrille = quadrilleRepository.findById(data.getQuadrille());
        if (quadrille == null) {
            throw QuadrilleNotFoundForPruningException.create(data.getQuadrille());
        }

        TypeEntity type = typeRepository.findById(data.getType());
        if (type == null) {
            throw PruningTypeNotFoundForPruningException.create(data.getType());
        }

        StatusEntity status = statusRepository.findById(data.getStatus());
        if (status == null) {
            throw StatusNotFoundForPruningException.create(data.getStatus());
        }

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
                data.getObservations()
        ));

        return null;
    }
}
