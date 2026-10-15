package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record UpdateSectorRequest(
        String name,
        UUID municipality
) {
}
