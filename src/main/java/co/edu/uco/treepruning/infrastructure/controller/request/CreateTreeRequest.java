package co.edu.uco.treepruning.infrastructure.controller.request;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTreeRequest(
        BigDecimal longitude,
        BigDecimal latitude,
        UUID family,
        UUID sector,
        UUID programming
) {
}
