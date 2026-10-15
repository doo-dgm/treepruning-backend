package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.GetMunicipalityByFilterUseCase;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.domain.GetMunicipalityDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetMunicipalityByFilterUseCaseImpl implements GetMunicipalityByFilterUseCase {

    @Override
    public List<GetMunicipalityDomain> execute(GetMunicipalityDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
