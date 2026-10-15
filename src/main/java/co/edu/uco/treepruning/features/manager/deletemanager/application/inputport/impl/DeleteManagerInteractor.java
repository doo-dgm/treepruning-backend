package co.edu.uco.treepruning.features.manager.deletemanager.application.inputport.impl;

import co.edu.uco.treepruning.features.manager.deletemanager.application.inputport.DeleteManagerInputPort;
import co.edu.uco.treepruning.features.manager.deletemanager.application.usecase.DeleteManagerUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteManagerInteractor implements DeleteManagerInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteManagerInteractor.class);

    private final DeleteManagerUseCase useCase;

    public DeleteManagerInteractor(DeleteManagerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteManagerInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
