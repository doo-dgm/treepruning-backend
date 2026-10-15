package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record CreateQuadrilleRequest(
        String quadrilleName,
        UUID manager
) {
}
