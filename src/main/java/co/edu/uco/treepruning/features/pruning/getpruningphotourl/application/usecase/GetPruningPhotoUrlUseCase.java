package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase;

import java.util.UUID;

import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto.PruningPhotoUrlDTO;

public interface GetPruningPhotoUrlUseCase {

    PruningPhotoUrlDTO execute(UUID pruningId);
}
