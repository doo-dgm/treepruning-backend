package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.usecase.domain.GetDocumentDomain;
import java.util.List;

public interface GetDocumentByFilterUseCase extends UseCase<GetDocumentDTO, List<GetDocumentDomain>> {
}
