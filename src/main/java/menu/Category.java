package menu;

import static menu.ExceptionMessage.*;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final Integer index;

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    private final String name;

    Category(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Category getCategoryByIndex(Integer index) {
        for (Category category : Category.values()) {
            if (category.index.equals(index)) {
                return category;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
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
