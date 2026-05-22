package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.GetPruningByFilterInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl.mapper.GetPruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.GetPruningByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetPruningByFilterInteractor implements GetPruningByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetPruningByFilterInteractor.class);

    private final GetPruningByFilterUseCase useCase;
    private final GetPruningDTOMapper dtoMapper;

    public GetPruningByFilterInteractor(GetPruningByFilterUseCase useCase,
            GetPruningDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public PageResult<GetPruningDTO> execute(GetPruningDTO filter) {
        log.info("GetPruningByFilter — page={}, size={}", filter.getPage(), filter.getSize());

        PageResult<GetPruningDTO> result = useCase.execute(filter)
                .mapContent(dtoMapper::toDTO);

        log.info("GetPruningByFilter — returned {} of {} total prunings",
                result.content().size(), result.totalElements());
        return result;
    }
}
