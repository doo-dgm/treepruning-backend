package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.GetStatusByFilterInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.impl.mapper.GetStatusDTOMapper;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.GetStatusByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetStatusByFilterInteractor implements GetStatusByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetStatusByFilterInteractor.class);

    private final GetStatusByFilterUseCase useCase;
    private final GetStatusDTOMapper dtoMapper;

    public GetStatusByFilterInteractor(GetStatusByFilterUseCase useCase,
            GetStatusDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetStatusDTO> execute(GetStatusDTO filter) {
        log.info("GetStatusByFilterInteractor — querying");
        List<GetStatusDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetStatusByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
