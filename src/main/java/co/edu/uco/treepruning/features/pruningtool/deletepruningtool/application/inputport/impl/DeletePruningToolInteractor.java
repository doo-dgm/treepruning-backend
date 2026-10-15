package co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.inputport.impl;

import co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.inputport.DeletePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.usecase.DeletePruningToolUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeletePruningToolInteractor implements DeletePruningToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeletePruningToolInteractor.class);

    private final DeletePruningToolUseCase useCase;

    public DeletePruningToolInteractor(DeletePruningToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeletePruningToolInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
