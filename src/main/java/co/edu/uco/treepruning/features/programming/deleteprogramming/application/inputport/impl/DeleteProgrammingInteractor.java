package co.edu.uco.treepruning.features.programming.deleteprogramming.application.inputport.impl;

import co.edu.uco.treepruning.features.programming.deleteprogramming.application.inputport.DeleteProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.deleteprogramming.application.usecase.DeleteProgrammingUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteProgrammingInteractor implements DeleteProgrammingInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteProgrammingInteractor.class);

    private final DeleteProgrammingUseCase useCase;

    public DeleteProgrammingInteractor(DeleteProgrammingUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteProgrammingInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
