package co.edu.uco.treepruning.features.auth.login.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;
import co.edu.uco.treepruning.features.auth.login.application.usecase.domain.LoginDomain;

public interface LoginUseCase
	extends UseCase<LoginDomain, LoginResponseDTO> {
}