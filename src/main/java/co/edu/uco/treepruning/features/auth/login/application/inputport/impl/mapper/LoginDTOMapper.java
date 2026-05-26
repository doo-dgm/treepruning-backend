package co.edu.uco.treepruning.features.auth.login.application.inputport.impl.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginRequestDTO;
import co.edu.uco.treepruning.features.auth.login.application.usecase.domain.LoginDomain;

@Mapper(componentModel = "spring")
public interface LoginDTOMapper {

    default LoginDomain toDomain(LoginRequestDTO dto) {
        if (ObjectHelper.isNull(dto)) return new LoginDomain();
        return new LoginDomain(
            dto.getUsername(),
            dto.getPassword(),
            dto.getRecaptchaToken()
        );
    }
}