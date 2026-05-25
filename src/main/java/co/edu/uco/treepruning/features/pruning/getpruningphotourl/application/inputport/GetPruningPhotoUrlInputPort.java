package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport;

import java.util.UUID;

import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto.PruningPhotoUrlDTO;

public interface GetPruningPhotoUrlInputPort {

    PruningPhotoUrlDTO execute(UUID pruningId);
}
