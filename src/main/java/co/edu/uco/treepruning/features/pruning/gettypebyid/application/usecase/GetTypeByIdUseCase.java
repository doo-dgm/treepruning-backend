package co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase;

import java.util.UUID;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.infrastructure.persistence
        .repository.entity.TypeEntity;

public interface GetTypeByIdUseCase extends UseCase<UUID, TypeEntity> {
}
