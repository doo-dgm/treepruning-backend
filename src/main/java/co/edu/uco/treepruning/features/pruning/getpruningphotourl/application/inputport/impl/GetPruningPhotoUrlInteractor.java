package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.GetPruningPhotoUrlInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto.PruningPhotoUrlDTO;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.GetPruningPhotoUrlUseCase;

@Service
@Transactional(readOnly = true)
public class GetPruningPhotoUrlInteractor implements GetPruningPhotoUrlInputPort {

    private static final Logger log = LoggerFactory.getLogger(GetPruningPhotoUrlInteractor.class);

    private final GetPruningPhotoUrlUseCase useCase;

    public GetPruningPhotoUrlInteractor(GetPruningPhotoUrlUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public PruningPhotoUrlDTO execute(UUID pruningId) {
        log.info("GetPruningPhotoUrl — pruningId={}", pruningId);
        PruningPhotoUrlDTO dto = useCase.execute(pruningId);
        log.debug("GetPruningPhotoUrl — presigned URL generated for pruningId={} (expires in {}s)",
                pruningId, dto.expiresInSeconds());
        return dto;
    }
}
