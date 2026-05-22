package co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.GetTypeByFilterUseCase;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.impl.mapper.GetTypeDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;

@Service
public class GetTypeByFilterUseCaseImpl implements GetTypeByFilterUseCase {

    private final TypeRepository typeRepository;
    private final GetTypeDomainMapper mapper;

    public GetTypeByFilterUseCaseImpl(TypeRepository typeRepository,
            GetTypeDomainMapper mapper) {
        this.typeRepository = typeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetTypeDomain> execute(GetTypeDTO filter) {
        return typeRepository.findByFilter(filter.getId(), filter.getName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
