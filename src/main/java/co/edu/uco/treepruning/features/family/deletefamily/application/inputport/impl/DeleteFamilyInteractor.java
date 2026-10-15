package co.edu.uco.treepruning.features.family.deletefamily.application.inputport.impl;

import co.edu.uco.treepruning.features.family.deletefamily.application.inputport.DeleteFamilyInputPort;
import co.edu.uco.treepruning.features.family.deletefamily.application.usecase.DeleteFamilyUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteFamilyInteractor implements DeleteFamilyInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteFamilyInteractor.class);

    private final DeleteFamilyUseCase useCase;

    public DeleteFamilyInteractor(DeleteFamilyUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteFamilyInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
