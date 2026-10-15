package co.edu.uco.treepruning.features.tree.createtree.application.inputport.impl;

import co.edu.uco.treepruning.features.tree.createtree.application.inputport.CreateTreeInputPort;
import co.edu.uco.treepruning.features.tree.createtree.application.inputport.dto.CreateTreeDTO;
import co.edu.uco.treepruning.features.tree.createtree.application.usecase.CreateTreeUseCase;
import co.edu.uco.treepruning.features.tree.createtree.application.usecase.domain.CreateTreeDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CreateTreeInteractor implements CreateTreeInputPort {

    private static final Logger log = LoggerFactory.getLogger(CreateTreeInteractor.class);

    private final CreateTreeUseCase useCase;

    public CreateTreeInteractor(CreateTreeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(CreateTreeDTO data) {
        log.info("CreateTreeInteractor — recibida solicitud");
        useCase.execute(new CreateTreeDomain(
                data.getLongitude(),
                data.getLatitude(),
                data.getFamily(),
                data.getSector(),
                data.getProgramming()));
        return null;
    }
}
