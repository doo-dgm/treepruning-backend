package co.edu.uco.treepruning.features.administrator.updateadministrator.application.inputport.impl;

import co.edu.uco.treepruning.features.administrator.updateadministrator.application.inputport.UpdateAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.inputport.dto.UpdateAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.usecase.UpdateAdministratorUseCase;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.usecase.domain.UpdateAdministratorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateAdministratorInteractor implements UpdateAdministratorInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateAdministratorInteractor.class);

    private final UpdateAdministratorUseCase useCase;

    public UpdateAdministratorInteractor(UpdateAdministratorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateAdministratorDTO data) {
        log.info("UpdateAdministratorInteractor — recibida solicitud");
        useCase.execute(new UpdateAdministratorDomain(
                data.getId(),
                data.getUsername(),
                data.getEmail(),
                data.isEmailConfirmed(),
                data.getPhone(),
                data.isPhoneConfirmed()));
        return null;
    }
}
