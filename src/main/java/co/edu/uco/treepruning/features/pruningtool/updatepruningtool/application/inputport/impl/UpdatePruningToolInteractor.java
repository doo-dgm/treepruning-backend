package co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.impl;

import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.UpdatePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.dto.UpdatePruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.usecase.UpdatePruningToolUseCase;
import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.usecase.domain.UpdatePruningToolDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdatePruningToolInteractor implements UpdatePruningToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdatePruningToolInteractor.class);

    private final UpdatePruningToolUseCase useCase;

    public UpdatePruningToolInteractor(UpdatePruningToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdatePruningToolDTO data) {
        log.info("UpdatePruningToolInteractor — recibida solicitud");
        useCase.execute(new UpdatePruningToolDomain(
                data.getId(),
                data.getPruning(),
                data.getTool()));
        return null;
    }
}
