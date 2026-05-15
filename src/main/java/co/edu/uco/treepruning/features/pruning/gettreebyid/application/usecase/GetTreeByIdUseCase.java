package co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase;

import java.util.UUID;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.infrastructure.persistence
        .repository.entity.TreeEntity;

public interface GetTreeByIdUseCase extends UseCase<UUID, TreeEntity> {
}
