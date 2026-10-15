package co.edu.uco.treepruning.features.person.deleteperson.application.inputport.impl;

import co.edu.uco.treepruning.features.person.deleteperson.application.inputport.DeletePersonInputPort;
import co.edu.uco.treepruning.features.person.deleteperson.application.usecase.DeletePersonUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeletePersonInteractor implements DeletePersonInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeletePersonInteractor.class);

    private final DeletePersonUseCase useCase;

    public DeletePersonInteractor(DeletePersonUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeletePersonInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
