package co.edu.uco.treepruning.crosscutting.exception;

import java.io.Serial;

public class TreePruningException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String userMessage;
    private final int httpStatus;

    protected TreePruningException(String userMessage,
            String technicalMessage, int httpStatus) {
        super(technicalMessage);
        this.userMessage = userMessage;
        this.httpStatus = httpStatus;
    }

    public static TreePruningException create(String userMessage,
            String technicalMessage) {
        return new TreePruningException(
                userMessage, technicalMessage, 400);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
