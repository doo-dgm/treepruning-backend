package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.GetSectorByFilterInputPort;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.impl.mapper.GetSectorDTOMapper;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.GetSectorByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetSectorByFilterInteractor implements GetSectorByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetSectorByFilterInteractor.class);

    private final GetSectorByFilterUseCase useCase;
    private final GetSectorDTOMapper dtoMapper;

    public GetSectorByFilterInteractor(GetSectorByFilterUseCase useCase,
            GetSectorDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetSectorDTO> execute(GetSectorDTO filter) {
        log.info("GetSectorByFilterInteractor — querying");
        List<GetSectorDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetSectorByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
