package menu.view;

public enum OutputType {
    START("점심 메뉴 추천을 시작합니다."),
    MENU_SUGGESTION_START("메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    CATEGORY_SUGGESTIION("[ 카테고리 | %s | %s | %s | %s | %s ]"),
    MENU_SUGGESTION_BY_COACH("메세지");

    private final String message;

    OutputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
