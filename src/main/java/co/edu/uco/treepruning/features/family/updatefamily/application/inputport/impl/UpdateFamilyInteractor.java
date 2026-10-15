package co.edu.uco.treepruning.features.family.updatefamily.application.inputport.impl;

import co.edu.uco.treepruning.features.family.updatefamily.application.inputport.UpdateFamilyInputPort;
import co.edu.uco.treepruning.features.family.updatefamily.application.inputport.dto.UpdateFamilyDTO;
import co.edu.uco.treepruning.features.family.updatefamily.application.usecase.UpdateFamilyUseCase;
import co.edu.uco.treepruning.features.family.updatefamily.application.usecase.domain.UpdateFamilyDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateFamilyInteractor implements UpdateFamilyInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateFamilyInteractor.class);

    private final UpdateFamilyUseCase useCase;

    public UpdateFamilyInteractor(UpdateFamilyUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateFamilyDTO data) {
        log.info("UpdateFamilyInteractor — recibida solicitud");
        useCase.execute(new UpdateFamilyDomain(
                data.getId(),
                data.getScientificName(),
                data.getCommonName()));
        return null;
    }
}
