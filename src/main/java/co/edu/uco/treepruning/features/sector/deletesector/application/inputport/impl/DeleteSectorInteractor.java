package co.edu.uco.treepruning.features.sector.deletesector.application.inputport.impl;

import co.edu.uco.treepruning.features.sector.deletesector.application.inputport.DeleteSectorInputPort;
import co.edu.uco.treepruning.features.sector.deletesector.application.usecase.DeleteSectorUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteSectorInteractor implements DeleteSectorInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteSectorInteractor.class);

    private final DeleteSectorUseCase useCase;

    public DeleteSectorInteractor(DeleteSectorUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteSectorInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
