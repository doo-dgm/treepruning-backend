package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.pagination.PageRequest;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.GetPruningByFilterUseCase;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl.mapper.GetPruningDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;

@Service
public class GetPruningByFilterUseCaseImpl implements GetPruningByFilterUseCase {

    private final PruningRepository pruningRepository;
    private final GetPruningDomainMapper mapper;

    public GetPruningByFilterUseCaseImpl(PruningRepository pruningRepository,
            GetPruningDomainMapper mapper) {
        this.pruningRepository = pruningRepository;
        this.mapper = mapper;
    }

    @Override
    public PageResult<GetPruningDomain> execute(GetPruningDTO filter) {
        LocalDate dateFilter = DateHelper.isDefaultDate(filter.getPlannedDate())
                ? null : filter.getPlannedDate();

        PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getSize());

        return pruningRepository
                .findByFilter(filter.getId(), filter.getStatus().getId(),
                        filter.getTree().getId(), filter.getQuadrille().getId(),
                        filter.getType().getId(), dateFilter, pageRequest)
                .mapContent(mapper::toDomain);
    }
}
