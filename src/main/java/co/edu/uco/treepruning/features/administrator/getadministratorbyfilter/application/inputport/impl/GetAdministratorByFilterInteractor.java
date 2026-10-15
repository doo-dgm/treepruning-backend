package co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.GetAdministratorByFilterInputPort;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.dto.GetAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.impl.mapper.GetAdministratorDTOMapper;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.GetAdministratorByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetAdministratorByFilterInteractor implements GetAdministratorByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetAdministratorByFilterInteractor.class);

    private final GetAdministratorByFilterUseCase useCase;
    private final GetAdministratorDTOMapper dtoMapper;

    public GetAdministratorByFilterInteractor(GetAdministratorByFilterUseCase useCase, GetAdministratorDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetAdministratorDTO> execute(GetAdministratorDTO filter) {
        log.info("GetAdministratorByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
