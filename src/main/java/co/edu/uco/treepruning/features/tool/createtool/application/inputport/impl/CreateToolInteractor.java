package co.edu.uco.treepruning.features.tool.createtool.application.inputport.impl;

import co.edu.uco.treepruning.features.tool.createtool.application.inputport.CreateToolInputPort;
import co.edu.uco.treepruning.features.tool.createtool.application.inputport.dto.CreateToolDTO;
import co.edu.uco.treepruning.features.tool.createtool.application.usecase.CreateToolUseCase;
import co.edu.uco.treepruning.features.tool.createtool.application.usecase.domain.CreateToolDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateToolInteractor implements CreateToolInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateToolInteractor.class);

    private final CreateToolUseCase useCase;

    public CreateToolInteractor(CreateToolUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateToolDTO data) {
        log.info("CreateToolInteractor — recibida solicitud");
        useCase.execute(new CreateToolDomain(
                data.getName(),
                data.getDescription()));
        return null;
    }
}
