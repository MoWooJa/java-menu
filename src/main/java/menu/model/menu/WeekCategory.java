package menu.model.menu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.exception.CategoryException;

public class WeekCategory {

    public static final int MAX_DUPLICATED_CATEGORY = 1;
    public static final String MAX_DUPLICATED_EXCEPTION = "[ERROR] 최대 중복 카테고리 횟수 초과";
    List<Category> categories;

    public WeekCategory(List<Category> categories) {
        this.categories = categories;
    }

    private void validate(List<Category> categories) {
        Set<Category> categoryPool = new HashSet<>(categories);
        if (categoryPool.size() < categories.size() - MAX_DUPLICATED_CATEGORY) {
            throw new CategoryException(MAX_DUPLICATED_EXCEPTION);
        }
    }
}
