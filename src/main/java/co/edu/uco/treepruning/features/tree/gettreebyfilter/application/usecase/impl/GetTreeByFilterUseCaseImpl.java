package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.GetTreeByFilterUseCase;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.impl.mapper.GetTreeDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;

@Service
public class GetTreeByFilterUseCaseImpl implements GetTreeByFilterUseCase {

    private final TreeRepository treeRepository;
    private final GetTreeDomainMapper mapper;

    public GetTreeByFilterUseCaseImpl(TreeRepository treeRepository,
            GetTreeDomainMapper mapper) {
        this.treeRepository = treeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetTreeDomain> execute(GetTreeDTO filter) {
        return treeRepository.findByFilter(filter.getId(), filter.getFamily().getId(), filter.getSector().getId())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
