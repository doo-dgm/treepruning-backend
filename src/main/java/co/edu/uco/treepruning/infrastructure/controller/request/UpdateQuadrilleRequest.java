package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record UpdateQuadrilleRequest(
        String quadrilleName,
        UUID manager
) {
}
