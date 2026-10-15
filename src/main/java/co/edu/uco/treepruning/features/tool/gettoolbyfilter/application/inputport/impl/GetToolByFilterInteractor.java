package co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.GetToolByFilterInputPort;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.impl.mapper.GetToolDTOMapper;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.usecase.GetToolByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetToolByFilterInteractor implements GetToolByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetToolByFilterInteractor.class);

    private final GetToolByFilterUseCase useCase;
    private final GetToolDTOMapper dtoMapper;

    public GetToolByFilterInteractor(GetToolByFilterUseCase useCase, GetToolDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetToolDTO> execute(GetToolDTO filter) {
        log.info("GetToolByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
