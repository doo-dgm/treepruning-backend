package co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.impl;

import co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.UpdateManagerInputPort;
import co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.dto.UpdateManagerDTO;
import co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.UpdateManagerUseCase;
import co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.domain.UpdateManagerDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateManagerInteractor implements UpdateManagerInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateManagerInteractor.class);

    private final UpdateManagerUseCase useCase;

    public UpdateManagerInteractor(UpdateManagerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateManagerDTO data) {
        log.info("UpdateManagerInteractor — recibida solicitud");
        useCase.execute(new UpdateManagerDomain(
                data.getId(),
                data.getPerson()));
        return null;
    }
}
