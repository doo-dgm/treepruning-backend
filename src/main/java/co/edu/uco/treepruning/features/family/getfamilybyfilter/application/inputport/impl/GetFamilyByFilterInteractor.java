package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.GetFamilyByFilterInputPort;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.impl.mapper.GetFamilyDTOMapper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.GetFamilyByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetFamilyByFilterInteractor implements GetFamilyByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetFamilyByFilterInteractor.class);

    private final GetFamilyByFilterUseCase useCase;
    private final GetFamilyDTOMapper dtoMapper;

    public GetFamilyByFilterInteractor(GetFamilyByFilterUseCase useCase,
            GetFamilyDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetFamilyDTO> execute(GetFamilyDTO filter) {
        log.info("GetFamilyByFilterInteractor — querying");
        List<GetFamilyDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetFamilyByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
