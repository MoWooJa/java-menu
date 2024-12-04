package menu.exception;

public enum ExceptionAnnounce {

    INVALID_CHAR_INPUT("[ERROR] 잘못된 입력입니다. 다시 입력해주세요. (한글과 구분자 , 만 가능합니다.)"),
    NAME_SIZE_EXCEPTION("[ERROR] 코치 이름은 최소 2글자 이상 최대 4글자 이하로 입력해야 합니다."),
    MIN_NAMES_INPUT_EXCEPTION("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    MAX_OVER_NAMES_INPUT_EXCEPTION("[ERROR] 코치는 최대 5명 이하로 입력해야 합니다."),
    DUPLICATED_NAME_INPUT_EXCEPTION("[ERROR] 코치 이름은 중복될 수 없습니다.");

    private final String message;

    ExceptionAnnounce(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
