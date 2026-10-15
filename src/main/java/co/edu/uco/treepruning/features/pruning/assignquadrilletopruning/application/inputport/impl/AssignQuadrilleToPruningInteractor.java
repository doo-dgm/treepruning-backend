package co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.impl;

import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.AssignQuadrilleToPruningInputPort;
import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.dto.AssignQuadrilleToPruningDTO;
import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.usecase.AssignQuadrilleToPruningUseCase;
import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.usecase.domain.AssignQuadrilleToPruningDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AssignQuadrilleToPruningInteractor implements AssignQuadrilleToPruningInputPort {

    private static final Logger log = LoggerFactory.getLogger(AssignQuadrilleToPruningInteractor.class);

    private final AssignQuadrilleToPruningUseCase useCase;

    public AssignQuadrilleToPruningInteractor(AssignQuadrilleToPruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(AssignQuadrilleToPruningDTO data) {
        log.info("AssignQuadrilleToPruningInteractor — recibida solicitud");
        useCase.execute(new AssignQuadrilleToPruningDomain(
                data.getId(),
                data.getQuadrille()));
        return null;
    }
}
