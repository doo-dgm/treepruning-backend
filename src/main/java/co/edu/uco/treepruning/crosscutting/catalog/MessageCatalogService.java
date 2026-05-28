package co.edu.uco.treepruning.crosscutting.catalog;

import java.util.Map;

public interface MessageCatalogService {

    /** Resuelve el texto del mensaje por codigo en el locale por defecto (es). */
    String resolve(String codigo);

    /** Resuelve e interpola variables en el locale por defecto (es). */
    String resolve(String codigo, Map<String, Object> vars);

    /** Resuelve el texto del mensaje por codigo en el locale indicado. */
    String resolve(String codigo, String locale);

    /** Resuelve e interpola variables en el locale indicado. */
    String resolve(String codigo, Map<String, Object> vars, String locale);
}
