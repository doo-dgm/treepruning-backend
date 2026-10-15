package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import java.util.List;

public interface GetDocumentByFilterInputPort extends InputPort<GetDocumentDTO, List<GetDocumentDTO>> {
}
