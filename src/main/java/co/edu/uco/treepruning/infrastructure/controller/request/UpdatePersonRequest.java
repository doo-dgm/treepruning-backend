package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record UpdatePersonRequest(
        String firstName,
        String secondName,
        String firstLastName,
        String secondLastName,
        UUID document,
        String documentNumber,
        LocalDate birthDate,
        String address,
        String email,
        String phone
) {
}
