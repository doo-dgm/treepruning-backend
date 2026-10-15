package co.edu.uco.treepruning.features.tree.deletetree.application.inputport.impl;

import co.edu.uco.treepruning.features.tree.deletetree.application.inputport.DeleteTreeInputPort;
import co.edu.uco.treepruning.features.tree.deletetree.application.usecase.DeleteTreeUseCase;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteTreeInteractor implements DeleteTreeInputPort {

    private static final Logger log = LoggerFactory.getLogger(DeleteTreeInteractor.class);

    private final DeleteTreeUseCase useCase;

    public DeleteTreeInteractor(DeleteTreeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UUID id) {
        log.info("DeleteTreeInteractor — eliminando {}", id);
        return useCase.execute(id);
    }
}
