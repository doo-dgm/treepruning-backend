package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record CreateSectorRequest(
        String name,
        UUID municipality
) {
}
