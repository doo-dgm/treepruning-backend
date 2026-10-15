package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.impl;

import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.GetDocumentByFilterUseCase;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.domain.GetDocumentDomain;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetDocumentByFilterUseCaseImpl implements GetDocumentByFilterUseCase {

    @Override
    public List<GetDocumentDomain> execute(GetDocumentDTO filter) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
