package co.edu.uco.treepruning.features.administrator.deleteadministrator.application.inputport.impl;

import co.edu.uco.treepruning.features.administrator.deleteadministrator.application.inputport.DeleteAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.deleteadministrator.application.usecase.DeleteAdministratorUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteAdministratorInteractor implements DeleteAdministratorInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteAdministratorInteractor.class);

    private final DeleteAdministratorUseCase useCase;

    public DeleteAdministratorInteractor(DeleteAdministratorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteAdministratorInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
