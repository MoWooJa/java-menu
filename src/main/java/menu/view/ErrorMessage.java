package menu.view;

public enum ErrorMessage {
    DEFAULT("[ERROR] 유효하지 않은 입력입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
