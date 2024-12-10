package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendService {

    public void dayLoop(Coaches coaches, List<Category> categories) {
        // 월 화 수 목 금 loop
        for (int i = 0; i < 5; i++) {
            // 요일의 카테고리
            Category category = categories.get(i);
            // coach loop
            for (Coach coach : coaches.getCoaches()) {
                // 코치 메뉴 정해주기
                Menus menu = selectedByCategory(category);
                if (!coach.canEat(menu)) {
                    Menus loopMenu = loopMenu(coach, category);
                    coach.addEatList(loopMenu);
                    continue;
                }
                coach.addEatList(menu);
            }
        }
    }

    public Menus loopMenu(Coach coach, Category category) {
        while (true) {
            Menus menu = selectedByCategory(category);
            if (coach.canEat(menu)) {
                return menu;
            }
        }
    }

    // 메뉴 선택하기
    public Menus selectedByCategory(Category category) {
        return RecommendGenerator.selectMenu(Menus.getByCategory(category));
    }

    // 카테고리 선택하기
    public List<Category> selectCategory() {
        Map<Category, Integer> categoryCounter = new HashMap<>();
        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Category category = RecommendGenerator.selectCategory();
            if (!categoryCounter.containsKey(category)) {
                categoryCounter.put(category, 1);
                categories.add(category);
                continue;
            }
            // 키 있는데 2개 이상이니?
            if (categoryCounter.get(category) >= 2) {
                Category loopCategory = selectCategoryLoop(categoryCounter);
                categoryCounter.put(loopCategory, categoryCounter.getOrDefault(loopCategory, 1) + 1);
                categories.add(loopCategory);
                continue;
            }
            // 키있니? 그리고 2개 이하니?
            categoryCounter.put(category, categoryCounter.get(category) + 1);
            categories.add(category);
        }
        return categories;
    }

    public Category selectCategoryLoop(Map<Category, Integer> categoryCounter) {
        while (true) {
            Category category = RecommendGenerator.selectCategory();
            // 키가 없덩가 2개 보다 적다
            if (!categoryCounter.containsKey(category) || categoryCounter.get(category) < 2) {
                return category;
            }
        }
    }
}
