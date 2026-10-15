package co.edu.uco.treepruning.features.manager.createmanager.application.inputport.impl;

import co.edu.uco.treepruning.features.manager.createmanager.application.inputport.CreateManagerInputPort;
import co.edu.uco.treepruning.features.manager.createmanager.application.inputport.dto.CreateManagerDTO;
import co.edu.uco.treepruning.features.manager.createmanager.application.usecase.CreateManagerUseCase;
import co.edu.uco.treepruning.features.manager.createmanager.application.usecase.domain.CreateManagerDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateManagerInteractor implements CreateManagerInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateManagerInteractor.class);

    private final CreateManagerUseCase useCase;

    public CreateManagerInteractor(CreateManagerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateManagerDTO data) {
        log.info("CreateManagerInteractor — recibida solicitud");
        useCase.execute(new CreateManagerDomain(
                data.getPerson()));
        return null;
    }
}
