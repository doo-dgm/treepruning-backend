package co.edu.uco.treepruning.features.document.updatedocument.application.inputport.impl;

import co.edu.uco.treepruning.features.document.updatedocument.application.inputport.UpdateDocumentInputPort;
import co.edu.uco.treepruning.features.document.updatedocument.application.inputport.dto.UpdateDocumentDTO;
import co.edu.uco.treepruning.features.document.updatedocument.application.usecase.UpdateDocumentUseCase;
import co.edu.uco.treepruning.features.document.updatedocument.application.usecase.domain.UpdateDocumentDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateDocumentInteractor implements UpdateDocumentInputPort {

    private static final Logger log = LoggerFactory.getLogger(UpdateDocumentInteractor.class);

    private final UpdateDocumentUseCase useCase;

    public UpdateDocumentInteractor(UpdateDocumentUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(UpdateDocumentDTO data) {
        log.info("UpdateDocumentInteractor — recibida solicitud");
        useCase.execute(new UpdateDocumentDomain(
                data.getId(),
                data.getName(),
                data.getCode()));
        return null;
    }
}
