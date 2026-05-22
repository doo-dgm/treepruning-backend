package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.GetQuadrilleByFilterUseCase;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.impl.mapper.GetQuadrilleDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;

@Service
public class GetQuadrilleByFilterUseCaseImpl implements GetQuadrilleByFilterUseCase {

    private final QuadrilleRepository quadrilleRepository;
    private final GetQuadrilleDomainMapper mapper;

    public GetQuadrilleByFilterUseCaseImpl(QuadrilleRepository quadrilleRepository,
            GetQuadrilleDomainMapper mapper) {
        this.quadrilleRepository = quadrilleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetQuadrilleDomain> execute(GetQuadrilleDTO filter) {
        return quadrilleRepository.findByFilter(filter.getId(), filter.getQuadrilleName(), filter.getManager().getId())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
