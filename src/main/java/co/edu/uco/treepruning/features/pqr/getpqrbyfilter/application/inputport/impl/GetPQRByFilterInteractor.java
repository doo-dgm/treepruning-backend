package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.GetPQRByFilterInputPort;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.impl.mapper.GetPQRDTOMapper;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.usecase.GetPQRByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetPQRByFilterInteractor implements GetPQRByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetPQRByFilterInteractor.class);

    private final GetPQRByFilterUseCase useCase;
    private final GetPQRDTOMapper dtoMapper;

    public GetPQRByFilterInteractor(GetPQRByFilterUseCase useCase, GetPQRDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetPQRDTO> execute(GetPQRDTO filter) {
        log.info("GetPQRByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
