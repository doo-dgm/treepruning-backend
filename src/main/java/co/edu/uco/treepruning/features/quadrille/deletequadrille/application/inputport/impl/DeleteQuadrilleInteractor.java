package co.edu.uco.treepruning.features.quadrille.deletequadrille.application.inputport.impl;

import co.edu.uco.treepruning.features.quadrille.deletequadrille.application.inputport.DeleteQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.deletequadrille.application.usecase.DeleteQuadrilleUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteQuadrilleInteractor implements DeleteQuadrilleInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteQuadrilleInteractor.class);

    private final DeleteQuadrilleUseCase useCase;

    public DeleteQuadrilleInteractor(DeleteQuadrilleUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteQuadrilleInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
