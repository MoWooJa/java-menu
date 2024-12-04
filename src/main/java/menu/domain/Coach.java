package menu.domain;

import menu.util.exception.ErrorMessage;

public class Coach {
    private String name;

    public Coach(String name) {
        validate(name);
        this.name = name;

    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException(ErrorMessage.NON_COACHE_NAME_SIZE.getMessage());
        }
    }
}
