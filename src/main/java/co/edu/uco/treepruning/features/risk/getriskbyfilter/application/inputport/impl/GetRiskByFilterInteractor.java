package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.GetRiskByFilterInputPort;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.impl.mapper.GetRiskDTOMapper;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.GetRiskByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetRiskByFilterInteractor implements GetRiskByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetRiskByFilterInteractor.class);

    private final GetRiskByFilterUseCase useCase;
    private final GetRiskDTOMapper dtoMapper;

    public GetRiskByFilterInteractor(GetRiskByFilterUseCase useCase, GetRiskDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetRiskDTO> execute(GetRiskDTO filter) {
        log.info("GetRiskByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
