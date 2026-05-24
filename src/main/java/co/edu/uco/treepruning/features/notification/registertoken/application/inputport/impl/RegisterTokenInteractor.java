package co.edu.uco.treepruning.features.notification.registertoken.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.RegisterTokenInputPort;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto.RegisterTokenDTO;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.impl.mapper.RegisterTokenDTOMapper;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.RegisterTokenUseCase;

@Service
@Transactional(readOnly = true)
public class RegisterTokenInteractor implements RegisterTokenInputPort {

    private static final Logger log = LoggerFactory.getLogger(RegisterTokenInteractor.class);

    private final RegisterTokenUseCase    useCase;
    private final RegisterTokenDTOMapper  dtoMapper;

    public RegisterTokenInteractor(
            RegisterTokenUseCase useCase,
            RegisterTokenDTOMapper dtoMapper) {
        this.useCase    = useCase;
        this.dtoMapper  = dtoMapper;
    }

    @Override
    public Void execute(RegisterTokenDTO dto) {
        log.info("RegisterTokenInteractor — registering token for user {}", dto.getUserId());
        useCase.execute(dtoMapper.toDomain(dto));
        log.info("RegisterTokenInteractor — token registered successfully");
        return null;
    }
}