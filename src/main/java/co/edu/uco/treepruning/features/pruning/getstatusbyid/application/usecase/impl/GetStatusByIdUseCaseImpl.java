package co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase.GetStatusByIdUseCase;
import co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase.rules.StatusNotFoundException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;

@Service
public class GetStatusByIdUseCaseImpl implements GetStatusByIdUseCase {

    private final StatusRepository statusRepository;

    public GetStatusByIdUseCaseImpl(
            StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public StatusEntity execute(UUID id) {
        StatusEntity status = statusRepository.findById(id);
        if (status == null) {
            throw StatusNotFoundException.create(id);
        }
        return status;
    }
}
