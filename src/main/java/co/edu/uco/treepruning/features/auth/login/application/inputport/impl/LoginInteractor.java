package co.edu.uco.treepruning.features.auth.login.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



import co.edu.uco.treepruning.features.auth.login.application.inputport.LoginInputPort;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginRequestDTO;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;
import co.edu.uco.treepruning.features.auth.login.application.inputport.impl.mapper.LoginDTOMapper;
import co.edu.uco.treepruning.features.auth.login.application.usecase.LoginUseCase;


@Service
public class LoginInteractor implements LoginInputPort {

    private static final Logger log = LoggerFactory.getLogger(LoginInteractor.class);

    private final LoginUseCase    useCase;
    private final LoginDTOMapper  dtoMapper;

    public LoginInteractor(LoginUseCase useCase, LoginDTOMapper dtoMapper) {
        this.useCase   = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public LoginResponseDTO execute(LoginRequestDTO dto) {
        log.info("LoginInteractor — processing login for user: {}", dto.getUsername());
        LoginResponseDTO result = useCase.execute(dtoMapper.toDomain(dto));
        log.info("LoginInteractor — login completed for user: {}", dto.getUsername());
        return result;
    }
}