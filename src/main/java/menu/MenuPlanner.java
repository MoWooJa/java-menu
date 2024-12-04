package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import menu.exception.CategoryException;
import menu.model.Coaches;
import menu.model.menu.Category;
import menu.model.menu.WeekCategory;

public class MenuPlanner {

    public static final int MIN_CATEGORY_CODE = 1;
    public static final int MAX_CATEGORY_CODE = 5;
    public static final int MAX_WEEK = 5;

    public void getMenuPlan(Coaches coaches) {
        WeekCategory weekCategory = retryHandle(this::getWeekCategories);
        List<Category> categories = weekCategory.getCategories();
        coaches.recommendedMenu(categories);
    }

    private WeekCategory getWeekCategories() {
        List<Category> weekCategories = new ArrayList<>();
        for (int weekIdx = 0; weekIdx < MAX_WEEK; weekIdx++) {
            weekCategories.add(Category.getCategoryByCode(
                    Randoms.pickNumberInRange(MIN_CATEGORY_CODE, MAX_CATEGORY_CODE)));
        }
        return new WeekCategory(Collections.unmodifiableList(weekCategories));
    }

    private <T> T retryHandle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CategoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
