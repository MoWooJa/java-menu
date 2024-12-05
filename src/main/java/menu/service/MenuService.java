package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.RecommandMenu;

public class MenuService {
    Category category = new Category();

    public RecommandMenu createRecommandMenu(List<Coach> coaches) {
        Map<String, Integer> categoryCount = new HashMap<>();
        List<String> weeklyCategory = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String categoryName = createCategory(categoryCount);
            weeklyCategory.add(categoryName);
            for (Coach coach : coaches) {
                createCoachCategoryMenu(coach,category,categoryName);
            }
        }
        return new RecommandMenu(weeklyCategory,coaches);
    }

    private String createCategory(Map<String, Integer> categoryCount) {
        while (true) {
            try {
                String categoryName = category.get(Randoms.pickNumberInRange(1, 5));
                checkCategoryCount(categoryName, categoryCount);
                return categoryName;
            } catch (IllegalArgumentException iae) {
            }
        }
    }

    private void checkCategoryCount(String category, Map<String, Integer> categoryCount) {
        if (!categoryCount.containsKey(category)) {
            categoryCount.put(category, 1);
            return;
        }
        if (categoryCount.get(category) >= 2) {
            throw new IllegalArgumentException();
        }
        categoryCount.put(category, categoryCount.get(category) + 1);
    }

    private void createCoachCategoryMenu(Coach coach,Category category,String categoryName) {
        List<String>categoryMenus =  category.getMenus().get(categoryName);
        while (true) {
            try {
                String menu = Randoms.shuffle(categoryMenus).get(0);
                coach.addOrderFood(menu);
                return;
            } catch (IllegalArgumentException iae) {
            }
        }
    }

}
