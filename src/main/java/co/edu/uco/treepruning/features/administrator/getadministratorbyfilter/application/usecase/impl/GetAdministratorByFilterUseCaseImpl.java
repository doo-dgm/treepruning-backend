package co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.dto.GetAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.GetAdministratorByFilterUseCase;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.domain.GetAdministratorDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetAdministratorByFilterUseCaseImpl implements GetAdministratorByFilterUseCase {

    @Override
    public List<GetAdministratorDomain> execute(GetAdministratorDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
