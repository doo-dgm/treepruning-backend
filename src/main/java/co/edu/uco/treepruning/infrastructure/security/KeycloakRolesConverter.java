package co.edu.uco.treepruning.infrastructure.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Extrae los roles de realm de un JWT emitido por Keycloak y los convierte en
 * GrantedAuthority con prefijo ROLE_ para que funcione con hasRole() de Spring.
 *
 * Estructura del claim en el JWT de Keycloak:
 * {
 *   "realm_access": {
 *     "roles": ["ADMIN", "ENCARGADO", "PERSONA", ...]
 *   }
 * }
 *
 * Resultado: ROLE_ADMIN, ROLE_ENCARGADO, ROLE_PERSONA
 */
public final class KeycloakRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
        if (realmAccess == null) {
            return Collections.emptyList();
        }
        Object rolesObj = realmAccess.get("roles");
        if (!(rolesObj instanceof List)) {
            return Collections.emptyList();
        }
        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) rolesObj;
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                .collect(Collectors.toList());
    }
}
