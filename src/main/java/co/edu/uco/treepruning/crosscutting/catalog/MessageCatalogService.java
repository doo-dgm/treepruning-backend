package co.edu.uco.treepruning.crosscutting.catalog;

import java.util.Map;

public interface MessageCatalogService {

    /** Resuelve el texto del mensaje por codigo. */
    String resolve(String codigo);

    /** Resuelve e interpola variables con la sintaxis {{variable}}. */
    String resolve(String codigo, Map<String, Object> vars);
}
