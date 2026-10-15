package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.domain.GetMunicipalityDomain;
import java.util.List;

public interface GetMunicipalityByFilterUseCase extends UseCase<GetMunicipalityDTO, List<GetMunicipalityDomain>> {
}
