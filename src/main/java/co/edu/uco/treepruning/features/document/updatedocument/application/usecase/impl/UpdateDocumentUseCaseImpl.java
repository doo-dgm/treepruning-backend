package co.edu.uco.treepruning.features.document.updatedocument.application.usecase.impl;

import co.edu.uco.treepruning.features.document.updatedocument.application.usecase.UpdateDocumentUseCase;
import co.edu.uco.treepruning.features.document.updatedocument.application.usecase.domain.UpdateDocumentDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateDocumentUseCaseImpl implements UpdateDocumentUseCase {

    @Override
    public Void execute(UpdateDocumentDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
