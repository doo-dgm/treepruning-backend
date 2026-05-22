package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.GetQuadrilleByFilterInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.impl.mapper.GetQuadrilleDTOMapper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.GetQuadrilleByFilterUseCase;

@Service
@Transactional(readOnly = true)
public class GetQuadrilleByFilterInteractor implements GetQuadrilleByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetQuadrilleByFilterInteractor.class);

    private final GetQuadrilleByFilterUseCase useCase;
    private final GetQuadrilleDTOMapper dtoMapper;

    public GetQuadrilleByFilterInteractor(GetQuadrilleByFilterUseCase useCase,
            GetQuadrilleDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetQuadrilleDTO> execute(GetQuadrilleDTO filter) {
        log.info("GetQuadrilleByFilterInteractor — querying");
        List<GetQuadrilleDTO> result = useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
        log.info("GetQuadrilleByFilterInteractor — returned {} results", result.size());
        return result;
    }
}
