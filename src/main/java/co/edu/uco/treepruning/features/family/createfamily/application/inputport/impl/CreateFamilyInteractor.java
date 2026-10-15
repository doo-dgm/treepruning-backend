package co.edu.uco.treepruning.features.family.createfamily.application.inputport.impl;

import co.edu.uco.treepruning.features.family.createfamily.application.inputport.CreateFamilyInputPort;
import co.edu.uco.treepruning.features.family.createfamily.application.inputport.dto.CreateFamilyDTO;
import co.edu.uco.treepruning.features.family.createfamily.application.usecase.CreateFamilyUseCase;
import co.edu.uco.treepruning.features.family.createfamily.application.usecase.domain.CreateFamilyDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateFamilyInteractor implements CreateFamilyInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateFamilyInteractor.class);

    private final CreateFamilyUseCase useCase;

    public CreateFamilyInteractor(CreateFamilyUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateFamilyDTO data) {
        log.info("CreateFamilyInteractor — recibida solicitud");
        useCase.execute(new CreateFamilyDomain(
                data.getScientificName(),
                data.getCommonName()));
        return null;
    }
}
