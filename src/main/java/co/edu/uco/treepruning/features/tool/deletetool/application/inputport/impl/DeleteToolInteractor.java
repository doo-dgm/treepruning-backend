package co.edu.uco.treepruning.features.tool.deletetool.application.inputport.impl;

import co.edu.uco.treepruning.features.tool.deletetool.application.inputport.DeleteToolInputPort;
import co.edu.uco.treepruning.features.tool.deletetool.application.usecase.DeleteToolUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteToolInteractor implements DeleteToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteToolInteractor.class);

    private final DeleteToolUseCase useCase;

    public DeleteToolInteractor(DeleteToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteToolInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
