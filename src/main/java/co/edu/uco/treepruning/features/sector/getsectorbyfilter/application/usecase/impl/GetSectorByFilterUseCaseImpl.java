package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.GetSectorByFilterUseCase;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.impl.mapper.GetSectorDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.SectorRepository;

@Service
public class GetSectorByFilterUseCaseImpl implements GetSectorByFilterUseCase {

    private final SectorRepository sectorRepository;
    private final GetSectorDomainMapper mapper;

    public GetSectorByFilterUseCaseImpl(SectorRepository sectorRepository,
            GetSectorDomainMapper mapper) {
        this.sectorRepository = sectorRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetSectorDomain> execute(GetSectorDTO filter) {
        return sectorRepository.findByFilter(filter.getId(), filter.getName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
