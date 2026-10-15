package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.GetOperatorByFilterInputPort;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto.GetOperatorDTO;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.impl.mapper.GetOperatorDTOMapper;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.GetOperatorByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetOperatorByFilterInteractor implements GetOperatorByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetOperatorByFilterInteractor.class);

    private final GetOperatorByFilterUseCase useCase;
    private final GetOperatorDTOMapper dtoMapper;

    public GetOperatorByFilterInteractor(GetOperatorByFilterUseCase useCase, GetOperatorDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetOperatorDTO> execute(GetOperatorDTO filter) {
        log.info("GetOperatorByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
