package co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.impl;

import co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.CreateAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.dto.CreateAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.usecase.CreateAdministratorUseCase;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.usecase.domain.CreateAdministratorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateAdministratorInteractor implements CreateAdministratorInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateAdministratorInteractor.class);

    private final CreateAdministratorUseCase useCase;

    public CreateAdministratorInteractor(CreateAdministratorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateAdministratorDTO data) {
        log.info("CreateAdministratorInteractor — recibida solicitud");
        useCase.execute(new CreateAdministratorDomain(
                data.getUsername(),
                data.getEmail(),
                data.isEmailConfirmed(),
                data.getPhone(),
                data.isPhoneConfirmed()));
        return null;
    }
}
