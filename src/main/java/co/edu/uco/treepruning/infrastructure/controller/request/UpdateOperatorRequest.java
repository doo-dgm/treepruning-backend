package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record UpdateOperatorRequest(
        UUID person,
        UUID quadrille
) {
}
