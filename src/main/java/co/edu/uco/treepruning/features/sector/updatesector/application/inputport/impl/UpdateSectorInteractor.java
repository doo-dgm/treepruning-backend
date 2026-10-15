package co.edu.uco.treepruning.features.sector.updatesector.application.inputport.impl;

import co.edu.uco.treepruning.features.sector.updatesector.application.inputport.UpdateSectorInputPort;
import co.edu.uco.treepruning.features.sector.updatesector.application.inputport.dto.UpdateSectorDTO;
import co.edu.uco.treepruning.features.sector.updatesector.application.usecase.UpdateSectorUseCase;
import co.edu.uco.treepruning.features.sector.updatesector.application.usecase.domain.UpdateSectorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateSectorInteractor implements UpdateSectorInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateSectorInteractor.class);

    private final UpdateSectorUseCase useCase;

    public UpdateSectorInteractor(UpdateSectorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateSectorDTO data) {
        log.info("UpdateSectorInteractor — recibida solicitud");
        useCase.execute(new UpdateSectorDomain(
                data.getId(),
                data.getName(),
                data.getMunicipality()));
        return null;
    }
}
