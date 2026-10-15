package co.edu.uco.treepruning.features.operator.deleteoperator.application.inputport.impl;

import co.edu.uco.treepruning.features.operator.deleteoperator.application.inputport.DeleteOperatorInputPort;
import co.edu.uco.treepruning.features.operator.deleteoperator.application.usecase.DeleteOperatorUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteOperatorInteractor implements DeleteOperatorInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteOperatorInteractor.class);

    private final DeleteOperatorUseCase useCase;

    public DeleteOperatorInteractor(DeleteOperatorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteOperatorInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
