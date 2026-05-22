package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.GetFamilyByFilterUseCase;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl.mapper.GetFamilyDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.FamilyRepository;

@Service
public class GetFamilyByFilterUseCaseImpl implements GetFamilyByFilterUseCase {

    private final FamilyRepository familyRepository;
    private final GetFamilyDomainMapper mapper;

    public GetFamilyByFilterUseCaseImpl(FamilyRepository familyRepository,
            GetFamilyDomainMapper mapper) {
        this.familyRepository = familyRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetFamilyDomain> execute(GetFamilyDTO filter) {
        return familyRepository.findByFilter(filter.getId(), filter.getCommonName(), filter.getScientificName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
