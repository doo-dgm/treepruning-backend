package co.edu.uco.treepruning.infrastructure.controller.request;


public record UpdateFamilyRequest(
        String scientificName,
        String commonName
) {
}
