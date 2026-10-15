package co.edu.uco.treepruning.features.sector.createsector.application.inputport.impl;

import co.edu.uco.treepruning.features.sector.createsector.application.inputport.CreateSectorInputPort;
import co.edu.uco.treepruning.features.sector.createsector.application.inputport.dto.CreateSectorDTO;
import co.edu.uco.treepruning.features.sector.createsector.application.usecase.CreateSectorUseCase;
import co.edu.uco.treepruning.features.sector.createsector.application.usecase.domain.CreateSectorDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateSectorInteractor implements CreateSectorInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateSectorInteractor.class);

    private final CreateSectorUseCase useCase;

    public CreateSectorInteractor(CreateSectorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateSectorDTO data) {
        log.info("CreateSectorInteractor — recibida solicitud");
        useCase.execute(new CreateSectorDomain(
                data.getName(),
                data.getMunicipality()));
        return null;
    }
}
