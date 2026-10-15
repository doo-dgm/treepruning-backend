package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record CreateOperatorRequest(
        UUID person,
        UUID quadrille
) {
}
