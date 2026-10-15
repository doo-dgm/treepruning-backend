package co.edu.uco.treepruning.features.pruning.deletepruning.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.deletepruning.application.inputport.DeletePruningInputPort;
import co.edu.uco.treepruning.features.pruning.deletepruning.application.usecase.DeletePruningUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeletePruningInteractor implements DeletePruningInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeletePruningInteractor.class);

    private final DeletePruningUseCase useCase;

    public DeletePruningInteractor(DeletePruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeletePruningInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
