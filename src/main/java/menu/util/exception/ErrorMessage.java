package menu.util.exception;

public enum ErrorMessage {
    NON_COACHES_COUNT_SIZE("[ERROR] 코치는 2명 이상 5명 이하를 입력해야합니다."),
    NON_COACHE_NAME_SIZE("[ERROR] 코치는 2명 이상 5명 이하를 입력해야합니다."),
    NON_FOOD_SIZE("[ERROR] 못먹는 음식은 2개 이하로 입력해야합니다."),
    FOOD_NON_EXIST("[ERROR] 해당 메뉴는 없는 메뉴 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
