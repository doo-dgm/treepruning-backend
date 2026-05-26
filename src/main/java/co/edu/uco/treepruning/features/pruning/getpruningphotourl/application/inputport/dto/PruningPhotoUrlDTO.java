package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto;

import java.util.List;

public record PruningPhotoUrlDTO(List<String> urls, int expiresInSeconds) {
}
