package co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase;

import java.util.UUID;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;

public interface GetStatusByIdUseCase extends UseCase<UUID, StatusEntity> {
}