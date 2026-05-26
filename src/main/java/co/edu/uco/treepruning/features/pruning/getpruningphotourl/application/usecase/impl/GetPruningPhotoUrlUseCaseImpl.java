package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.pagination.PageRequest;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto.PruningPhotoUrlDTO;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.GetPruningPhotoUrlUseCase;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.rules.PhotoNotAvailableForPruningException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.storage.PhotoStoragePort;
import co.edu.uco.treepruning.infrastructure.storage.StorageProperties;

@Service
public class GetPruningPhotoUrlUseCaseImpl implements GetPruningPhotoUrlUseCase {

    private final PruningRepository pruningRepository;
    private final PhotoStoragePort photoStorage;
    private final StorageProperties storageProperties;

    public GetPruningPhotoUrlUseCaseImpl(
            PruningRepository pruningRepository,
            PhotoStoragePort photoStorage,
            StorageProperties storageProperties) {
        this.pruningRepository = pruningRepository;
        this.photoStorage = photoStorage;
        this.storageProperties = storageProperties;
    }

    @Override
    public PruningPhotoUrlDTO execute(UUID pruningId) {
        PageResult<PruningEntity> result = pruningRepository.findByFilter(
                pruningId, null, null, null, null, null, PageRequest.of(0, 1));

        if (result.content().isEmpty()) {
            throw ResourceNotFoundException.create("Pruning", pruningId);
        }

        String raw = result.content().get(0).getPhotographicRecordPath();
        if (TextHelper.isEmptyWithTrim(raw)) {
            throw PhotoNotAvailableForPruningException.create(pruningId);
        }

        List<String> urls = Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(k -> !k.isEmpty())
                .map(photoStorage::presignedUrl)
                .toList();

        return new PruningPhotoUrlDTO(urls, storageProperties.getPresignedUrlExpirySeconds());
    }
}
