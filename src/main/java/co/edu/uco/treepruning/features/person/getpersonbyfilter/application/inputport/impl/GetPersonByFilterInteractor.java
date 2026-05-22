package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.GetPersonByFilterInputPort;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.impl.mapper.GetPersonDTOMapper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.GetPersonByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetPersonByFilterInteractor implements GetPersonByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetPersonByFilterInteractor.class);

    private final GetPersonByFilterUseCase useCase;
    private final GetPersonDTOMapper dtoMapper;

    public GetPersonByFilterInteractor(GetPersonByFilterUseCase useCase,
            GetPersonDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetPersonDTO> execute(GetPersonDTO filter) {
        log.info("GetPersonByFilterInteractor — querying");
        List<GetPersonDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetPersonByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
