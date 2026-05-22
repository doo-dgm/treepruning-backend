package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.GetProgrammingByFilterUseCase;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.impl.mapper.GetProgrammingDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.ProgrammingRepository;

@Service
public class GetProgrammingByFilterUseCaseImpl implements GetProgrammingByFilterUseCase {

    private final ProgrammingRepository programmingRepository;
    private final GetProgrammingDomainMapper mapper;

    public GetProgrammingByFilterUseCaseImpl(ProgrammingRepository programmingRepository,
            GetProgrammingDomainMapper mapper) {
        this.programmingRepository = programmingRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetProgrammingDomain> execute(GetProgrammingDTO filter) {
        return programmingRepository.findByFilter(filter.getId())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
