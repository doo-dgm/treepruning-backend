package co.edu.uco.treepruning.infrastructure.controller.request;


public record CreateFamilyRequest(
        String scientificName,
        String commonName
) {
}
