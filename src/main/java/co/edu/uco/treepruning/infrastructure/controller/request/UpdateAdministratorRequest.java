package co.edu.uco.treepruning.infrastructure.controller.request;


public record UpdateAdministratorRequest(
        String username,
        String email,
        boolean emailConfirmed,
        String phone,
        boolean phoneConfirmed
) {
}
