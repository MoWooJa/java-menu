package menu.exception;

public class InputException extends IllegalArgumentException {

    public InputException(String message) {
        super(message);
    }

    public InputException(ExceptionAnnounce exceptionAnnounce) {
        super(exceptionAnnounce.getMessage());
    }
}
