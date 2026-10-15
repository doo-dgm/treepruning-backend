package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.GetRiskByFilterUseCase;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.domain.GetRiskDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetRiskByFilterUseCaseImpl implements GetRiskByFilterUseCase {

    @Override
    public List<GetRiskDomain> execute(GetRiskDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
