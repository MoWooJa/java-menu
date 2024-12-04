package menu.view.inputview;

public enum InputViewType {

    NAME_REQUEST("코치의 이름을 입력해 주세요. (, 로 구분)"),
    CANT_EAT_MENU_REQUEST("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputViewType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
