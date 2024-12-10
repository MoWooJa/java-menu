package menu;

public enum ExceptionMessage {

    INVALID_INPUT("올바르지 않은 입력입니다."),
    INVALID_NOT_NUMERIC("숫자만 입력 가능합니다."),
    INVALID_COACH_INPUT("코치는 최소 2명 이상 입력해야 합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
