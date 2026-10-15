package co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.impl;

import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.CreatePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.dto.CreatePruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.usecase.CreatePruningToolUseCase;
import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.usecase.domain.CreatePruningToolDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreatePruningToolInteractor implements CreatePruningToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreatePruningToolInteractor.class);

    private final CreatePruningToolUseCase useCase;

    public CreatePruningToolInteractor(CreatePruningToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreatePruningToolDTO data) {
        log.info("CreatePruningToolInteractor — recibida solicitud");
        useCase.execute(new CreatePruningToolDomain(
                data.getPruning(),
                data.getTool()));
        return null;
    }
}
