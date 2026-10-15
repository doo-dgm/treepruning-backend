package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.GetMunicipalityByFilterInputPort;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.impl.mapper.GetMunicipalityDTOMapper;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.GetMunicipalityByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetMunicipalityByFilterInteractor implements GetMunicipalityByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetMunicipalityByFilterInteractor.class);

    private final GetMunicipalityByFilterUseCase useCase;
    private final GetMunicipalityDTOMapper dtoMapper;

    public GetMunicipalityByFilterInteractor(GetMunicipalityByFilterUseCase useCase, GetMunicipalityDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetMunicipalityDTO> execute(GetMunicipalityDTO filter) {
        log.info("GetMunicipalityByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
