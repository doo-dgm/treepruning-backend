package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.GetPQRByFilterUseCase;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.domain.GetPQRDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetPQRByFilterUseCaseImpl implements GetPQRByFilterUseCase {

    @Override
    public List<GetPQRDomain> execute(GetPQRDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
