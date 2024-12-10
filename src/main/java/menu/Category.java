package menu;

import static menu.ExceptionMessage.*;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final Integer index;
    private final String name;

    Category(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Category of(String name) {
        for (Category category : Category.values()) {
            if (category.name.equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }
}
