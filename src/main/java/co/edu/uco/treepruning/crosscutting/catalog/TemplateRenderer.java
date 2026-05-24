package co.edu.uco.treepruning.crosscutting.catalog;

import java.util.Map;

/**
 * Interpola variables en plantillas de texto con sintaxis {{variable}}.
 * Ejemplo: "Hola {{nombre}}" + {nombre: "Ana"} → "Hola Ana"
 */
public final class TemplateRenderer {

    private TemplateRenderer() {
    }

    public static String render(String template, Map<String, Object> vars) {
        if (template == null || vars == null || vars.isEmpty()) {
            return template;
        }
        String result = template;
        for (Map.Entry<String, Object> entry : vars.entrySet()) {
            result = result.replace(
                    "{{" + entry.getKey() + "}}",
                    entry.getValue() != null ? String.valueOf(entry.getValue()) : ""
            );
        }
        return result;
    }
}
