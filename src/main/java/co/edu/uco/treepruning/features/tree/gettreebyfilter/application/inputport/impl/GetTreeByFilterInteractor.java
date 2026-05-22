package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.GetTreeByFilterInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl.mapper.GetTreeDTOMapper;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.GetTreeByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetTreeByFilterInteractor implements GetTreeByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetTreeByFilterInteractor.class);

    private final GetTreeByFilterUseCase useCase;
    private final GetTreeDTOMapper dtoMapper;

    public GetTreeByFilterInteractor(GetTreeByFilterUseCase useCase,
            GetTreeDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetTreeDTO> execute(GetTreeDTO filter) {
        log.info("GetTreeByFilterInteractor — querying");
        List<GetTreeDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetTreeByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
