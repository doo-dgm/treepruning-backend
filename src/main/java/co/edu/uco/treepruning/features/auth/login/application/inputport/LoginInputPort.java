package co.edu.uco.treepruning.features.auth.login.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginRequestDTO;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;

public interface LoginInputPort
	extends InputPort<LoginRequestDTO, LoginResponseDTO> {
}