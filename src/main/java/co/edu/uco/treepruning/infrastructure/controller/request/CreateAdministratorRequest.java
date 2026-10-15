package co.edu.uco.treepruning.infrastructure.controller.request;


public record CreateAdministratorRequest(
        String username,
        String email,
        boolean emailConfirmed,
        String phone,
        boolean phoneConfirmed
) {
}
