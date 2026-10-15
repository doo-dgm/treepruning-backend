package co.edu.uco.treepruning.features.tree.updatetree.application.inputport.impl;

import co.edu.uco.treepruning.features.tree.updatetree.application.inputport.UpdateTreeInputPort;
import co.edu.uco.treepruning.features.tree.updatetree.application.inputport.dto.UpdateTreeDTO;
import co.edu.uco.treepruning.features.tree.updatetree.application.usecase.UpdateTreeUseCase;
import co.edu.uco.treepruning.features.tree.updatetree.application.usecase.domain.UpdateTreeDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateTreeInteractor implements UpdateTreeInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateTreeInteractor.class);

    private final UpdateTreeUseCase useCase;

    public UpdateTreeInteractor(UpdateTreeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateTreeDTO data) {
        log.info("UpdateTreeInteractor — recibida solicitud");
        useCase.execute(new UpdateTreeDomain(
                data.getId(),
                data.getLongitude(),
                data.getLatitude(),
                data.getFamily(),
                data.getSector(),
                data.getProgramming()));
        return null;
    }
}
