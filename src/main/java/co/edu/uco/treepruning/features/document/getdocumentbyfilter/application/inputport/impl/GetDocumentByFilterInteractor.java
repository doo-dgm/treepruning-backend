package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.impl;

import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.GetDocumentByFilterInputPort;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.impl.mapper.GetDocumentDTOMapper;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.GetDocumentByFilterUseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetDocumentByFilterInteractor implements GetDocumentByFilterInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetDocumentByFilterInteractor.class);

    private final GetDocumentByFilterUseCase useCase;
    private final GetDocumentDTOMapper dtoMapper;

    public GetDocumentByFilterInteractor(GetDocumentByFilterUseCase useCase, GetDocumentDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetDocumentDTO> execute(GetDocumentDTO filter) {
        log.info("GetDocumentByFilterInteractor — consultando");
        return useCase.execute(filter).stream().map(dtoMapper::toDTO).toList();
    }
}
