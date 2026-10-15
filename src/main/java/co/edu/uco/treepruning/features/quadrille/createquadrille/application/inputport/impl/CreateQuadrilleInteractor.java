package co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.impl;

import co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.CreateQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.dto.CreateQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.createquadrille.application.usecase.CreateQuadrilleUseCase;
import co.edu.uco.treepruning.features.quadrille.createquadrille.application.usecase.domain.CreateQuadrilleDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateQuadrilleInteractor implements CreateQuadrilleInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateQuadrilleInteractor.class);

    private final CreateQuadrilleUseCase useCase;

    public CreateQuadrilleInteractor(CreateQuadrilleUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateQuadrilleDTO data) {
        log.info("CreateQuadrilleInteractor — recibida solicitud");
        useCase.execute(new CreateQuadrilleDomain(
                data.getQuadrilleName(),
                data.getManager()));
        return null;
    }
}
