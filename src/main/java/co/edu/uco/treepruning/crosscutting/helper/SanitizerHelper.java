package co.edu.uco.treepruning.crosscutting.helper;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public final class SanitizerHelper {

    private static final PolicyFactory POLICY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    private SanitizerHelper() {
    }

    /**
     * Elimina HTML/scripts maliciosos del texto de entrada.
     * Retorna cadena vacía si el valor es null.
     */
    public static String sanitize(final String value) {
        if (TextHelper.isEmptyWithTrim(value)) {
            return TextHelper.getDefault();
        }
        return POLICY.sanitize(value.trim());
    }
}
