package co.edu.uco.treepruning.features.pruning
        .getquadrillebyid.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getquadrillebyid.application.usecase.GetQuadrilleByIdUseCase;
import co.edu.uco.treepruning.features.pruning.getquadrillebyid.application.usecase.rules.QuadrilleNotFoundException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

@Service
public class GetQuadrilleByIdUseCaseImpl implements GetQuadrilleByIdUseCase {

    private final QuadrilleRepository quadrilleRepository;

    public GetQuadrilleByIdUseCaseImpl(
            QuadrilleRepository quadrilleRepository) {
        this.quadrilleRepository = quadrilleRepository;
    }

    @Override
    public QuadrilleEntity execute(UUID id) {
        QuadrilleEntity quadrille = quadrilleRepository.findById(id);
        if (quadrille == null) {
            throw QuadrilleNotFoundException.create(id);
        }
        return quadrille;
    }
}
