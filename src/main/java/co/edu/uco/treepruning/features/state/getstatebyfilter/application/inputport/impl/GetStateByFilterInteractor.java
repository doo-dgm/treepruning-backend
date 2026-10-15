package co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.GetStateByFilterInputPort;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.impl.mapper.GetStateDTOMapper;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.GetStateByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetStateByFilterInteractor implements GetStateByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetStateByFilterInteractor.class);

    private final GetStateByFilterUseCase useCase;
    private final GetStateDTOMapper dtoMapper;

    public GetStateByFilterInteractor(GetStateByFilterUseCase useCase, GetStateDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetStateDTO> execute(GetStateDTO filter) {
        log.info("GetStateByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
