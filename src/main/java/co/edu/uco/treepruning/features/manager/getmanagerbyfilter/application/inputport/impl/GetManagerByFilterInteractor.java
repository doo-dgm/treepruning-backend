package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.GetManagerByFilterInputPort;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl.mapper.GetManagerDTOMapper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.GetManagerByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetManagerByFilterInteractor implements GetManagerByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetManagerByFilterInteractor.class);

    private final GetManagerByFilterUseCase useCase;
    private final GetManagerDTOMapper dtoMapper;

    public GetManagerByFilterInteractor(GetManagerByFilterUseCase useCase,
            GetManagerDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetManagerDTO> execute(GetManagerDTO filter) {
        log.info("GetManagerByFilterInteractor — querying");
        List<GetManagerDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetManagerByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
