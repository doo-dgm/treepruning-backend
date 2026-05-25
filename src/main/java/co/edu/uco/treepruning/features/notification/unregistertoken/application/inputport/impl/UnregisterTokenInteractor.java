package co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.UnregisterTokenInputPort;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.dto.UnregisterTokenDTO;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.impl.mapper.UnregisterTokenDTOMapper;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.usecase.UnregisterTokenUseCase;

@Service
@Transactional(readOnly = true)
public class UnregisterTokenInteractor implements UnregisterTokenInputPort {

    private static final Logger log = LoggerFactory.getLogger(UnregisterTokenInteractor.class);

    private final UnregisterTokenUseCase   useCase;
    private final UnregisterTokenDTOMapper dtoMapper;

    public UnregisterTokenInteractor(
            UnregisterTokenUseCase useCase,
            UnregisterTokenDTOMapper dtoMapper) {
        this.useCase   = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Void execute(UnregisterTokenDTO dto) {
        log.info("UnregisterTokenInteractor — unregistering token");
        useCase.execute(dtoMapper.toDomain(dto));
        log.info("UnregisterTokenInteractor — token unregistered successfully");
        return null;
    }
}