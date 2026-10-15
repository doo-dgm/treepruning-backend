package co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.GetPruningToolByFilterInputPort;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.dto.GetPruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.impl.mapper.GetPruningToolDTOMapper;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.usecase.GetPruningToolByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetPruningToolByFilterInteractor implements GetPruningToolByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetPruningToolByFilterInteractor.class);

    private final GetPruningToolByFilterUseCase useCase;
    private final GetPruningToolDTOMapper dtoMapper;

    public GetPruningToolByFilterInteractor(GetPruningToolByFilterUseCase useCase, GetPruningToolDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetPruningToolDTO> execute(GetPruningToolDTO filter) {
        log.info("GetPruningToolByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
