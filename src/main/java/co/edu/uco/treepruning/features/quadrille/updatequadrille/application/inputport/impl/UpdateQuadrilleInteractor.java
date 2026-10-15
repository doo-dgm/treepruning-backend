package co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.impl;

import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.UpdateQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.dto.UpdateQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.usecase.UpdateQuadrilleUseCase;
import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.usecase.domain.UpdateQuadrilleDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateQuadrilleInteractor implements UpdateQuadrilleInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateQuadrilleInteractor.class);

    private final UpdateQuadrilleUseCase useCase;

    public UpdateQuadrilleInteractor(UpdateQuadrilleUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateQuadrilleDTO data) {
        log.info("UpdateQuadrilleInteractor — recibida solicitud");
        useCase.execute(new UpdateQuadrilleDomain(
                data.getId(),
                data.getQuadrilleName(),
                data.getManager()));
        return null;
    }
}
