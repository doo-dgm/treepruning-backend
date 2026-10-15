package co.edu.uco.treepruning.features.tool.updatetool.application.inputport.impl;

import co.edu.uco.treepruning.features.tool.updatetool.application.inputport.UpdateToolInputPort;
import co.edu.uco.treepruning.features.tool.updatetool.application.inputport.dto.UpdateToolDTO;
import co.edu.uco.treepruning.features.tool.updatetool.application.usecase.UpdateToolUseCase;
import co.edu.uco.treepruning.features.tool.updatetool.application.usecase.domain.UpdateToolDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateToolInteractor implements UpdateToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateToolInteractor.class);

    private final UpdateToolUseCase useCase;

    public UpdateToolInteractor(UpdateToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateToolDTO data) {
        log.info("UpdateToolInteractor — recibida solicitud");
        useCase.execute(new UpdateToolDomain(
                data.getId(),
                data.getName(),
                data.getDescription()));
        return null;
    }
}
