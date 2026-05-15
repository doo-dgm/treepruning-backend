package co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase.GetTypeByIdUseCase;
import co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase.rules.TypeNotFoundException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Service
public class GetTypeByIdUseCaseImpl implements GetTypeByIdUseCase {

    private final TypeRepository typeRepository;

    public GetTypeByIdUseCaseImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public TypeEntity execute(UUID id) {
        TypeEntity type = typeRepository.findById(id);
        if (type == null) {
            throw TypeNotFoundException.create(id);
        }
        return type;
    }
}
