package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.GetStatusByFilterUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.impl.mapper.GetStatusDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;

@Service
public class GetStatusByFilterUseCaseImpl implements GetStatusByFilterUseCase {

    private final StatusRepository statusRepository;
    private final GetStatusDomainMapper mapper;

    public GetStatusByFilterUseCaseImpl(StatusRepository statusRepository,
            GetStatusDomainMapper mapper) {
        this.statusRepository = statusRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetStatusDomain> execute(GetStatusDTO filter) {
        return statusRepository.findByFilter(filter.getId(), filter.getName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
