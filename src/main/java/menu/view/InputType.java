package menu.view;

public enum InputType {
    COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    MENU_REJECTION("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
