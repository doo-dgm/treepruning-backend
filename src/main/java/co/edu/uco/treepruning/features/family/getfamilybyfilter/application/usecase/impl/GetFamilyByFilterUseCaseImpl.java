package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.GetFamilyByFilterUseCase;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl.mapper.GetFamilyDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.FamilyRepository;
import org.springframework.cache.annotation.Cacheable;

@Service
public class GetFamilyByFilterUseCaseImpl implements GetFamilyByFilterUseCase {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GetFamilyByFilterUseCaseImpl.class);

    private final FamilyRepository familyRepository;
    private final GetFamilyDomainMapper mapper;

    public GetFamilyByFilterUseCaseImpl(FamilyRepository familyRepository,
            GetFamilyDomainMapper mapper) {
        this.familyRepository = familyRepository;
        this.mapper = mapper;
    }

    @Override
    @Cacheable(cacheNames = "families", key = "'all'")
    public List<GetFamilyDomain> execute(GetFamilyDTO filter) {
        log.info("[CACHE-TEST] Ejecutando query a PostgreSQL - NO vino de cache");
        return familyRepository.findByFilter(filter.getId(), filter.getCommonName(), filter.getScientificName())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
