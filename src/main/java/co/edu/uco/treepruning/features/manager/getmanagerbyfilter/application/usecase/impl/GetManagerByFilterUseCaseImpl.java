package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.GetManagerByFilterUseCase;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.impl.mapper.GetManagerDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.ManagerRepository;

@Service
public class GetManagerByFilterUseCaseImpl implements GetManagerByFilterUseCase {

    private final ManagerRepository managerRepository;
    private final GetManagerDomainMapper mapper;

    public GetManagerByFilterUseCaseImpl(ManagerRepository managerRepository,
            GetManagerDomainMapper mapper) {
        this.managerRepository = managerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetManagerDomain> execute(GetManagerDTO filter) {
        return managerRepository.findByFilter(filter.getId())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
