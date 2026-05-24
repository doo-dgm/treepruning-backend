package co.edu.uco.treepruning.crosscutting.exception;

import java.io.Serial;
import java.util.Map;

public class TreePruningException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String userMessage;
    private final int httpStatus;
    private final String code;
    private final String technicalCode;
    private final Map<String, Object> variables;

    // Constructor original — backward compatible
    protected TreePruningException(String userMessage,
            String technicalMessage, int httpStatus) {
        super(technicalMessage);
        this.userMessage = userMessage;
        this.httpStatus = httpStatus;
        this.code = null;
        this.technicalCode = null;
        this.variables = null;
    }

    // Constructor con ambos codigos del catalogo
    protected TreePruningException(String code, String technicalCode,
            Map<String, Object> variables, int httpStatus) {
        super(technicalCode);
        this.userMessage = null;
        this.code = code;
        this.technicalCode = technicalCode;
        this.variables = variables;
        this.httpStatus = httpStatus;
    }

    /** Factory original — sigue funcionando igual que antes. */
    public static TreePruningException create(String userMessage,
            String technicalMessage) {
        return new TreePruningException(userMessage, technicalMessage, 400);
    }

    /** Factory con ambos codigos, sin variables. */
    public static TreePruningException fromCode(String code, String technicalCode) {
        return new TreePruningException(code, technicalCode, null, 400);
    }

    /** Factory con ambos codigos, variables compartidas para interpolacion. */
    public static TreePruningException fromCode(String code, String technicalCode,
            Map<String, Object> variables) {
        return new TreePruningException(code, technicalCode, variables, 400);
    }

    /** Factory con ambos codigos, variables y status HTTP personalizado. */
    public static TreePruningException fromCode(String code, String technicalCode,
            Map<String, Object> variables, int httpStatus) {
        return new TreePruningException(code, technicalCode, variables, httpStatus);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getTechnicalCode() {
        return technicalCode;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }
}
