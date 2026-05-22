package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.GetProgrammingByFilterInputPort;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl.mapper.GetProgrammingDTOMapper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.GetProgrammingByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetProgrammingByFilterInteractor implements GetProgrammingByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetProgrammingByFilterInteractor.class);

    private final GetProgrammingByFilterUseCase useCase;
    private final GetProgrammingDTOMapper dtoMapper;

    public GetProgrammingByFilterInteractor(GetProgrammingByFilterUseCase useCase,
            GetProgrammingDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetProgrammingDTO> execute(GetProgrammingDTO filter) {
        log.info("GetProgrammingByFilterInteractor — querying");
        List<GetProgrammingDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetProgrammingByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
