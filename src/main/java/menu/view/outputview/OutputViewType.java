package menu.view.outputview;

public enum OutputViewType {

    START_HEADER("점심 메뉴 추천을 시작합니다."),
    MENU_RESULT_HEADER("메뉴 추천 결과입니다.");

    private final String message;

    OutputViewType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
