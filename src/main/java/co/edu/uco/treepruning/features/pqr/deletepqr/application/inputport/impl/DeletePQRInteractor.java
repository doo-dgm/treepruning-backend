package co.edu.uco.treepruning.features.pqr.deletepqr.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.deletepqr.application.inputport.DeletePQRInputPort;
import co.edu.uco.treepruning.features.pqr.deletepqr.application.usecase.DeletePQRUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeletePQRInteractor implements DeletePQRInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeletePQRInteractor.class);

    private final DeletePQRUseCase useCase;

    public DeletePQRInteractor(DeletePQRUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeletePQRInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
