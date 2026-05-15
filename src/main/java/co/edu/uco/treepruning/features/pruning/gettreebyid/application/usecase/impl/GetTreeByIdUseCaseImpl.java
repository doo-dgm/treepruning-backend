package co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase.GetTreeByIdUseCase;
import co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase.rules.TreeNotFoundException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TreeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

@Service
public class GetTreeByIdUseCaseImpl implements GetTreeByIdUseCase {

    private final TreeRepository treeRepository;

    public GetTreeByIdUseCaseImpl(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public TreeEntity execute(UUID id) {
        TreeEntity tree = treeRepository.findById(id);
        if (tree == null) {
            throw TreeNotFoundException.create(id);
        }
        return tree;
    }
}
