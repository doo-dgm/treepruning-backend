package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.GetTypeByFilterInputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.impl.mapper.GetTypeDTOMapper;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.GetTypeByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetTypeByFilterInteractor implements GetTypeByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetTypeByFilterInteractor.class);

    private final GetTypeByFilterUseCase useCase;
    private final GetTypeDTOMapper dtoMapper;

    public GetTypeByFilterInteractor(GetTypeByFilterUseCase useCase,
            GetTypeDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetTypeDTO> execute(GetTypeDTO filter) {
        log.info("GetTypeByFilterInteractor — querying");
        List<GetTypeDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetTypeByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
