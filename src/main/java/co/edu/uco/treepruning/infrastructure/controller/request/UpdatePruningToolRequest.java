package co.edu.uco.treepruning.infrastructure.controller.request;

import java.util.UUID;

public record UpdatePruningToolRequest(
        UUID pruning,
        UUID tool
) {
}
