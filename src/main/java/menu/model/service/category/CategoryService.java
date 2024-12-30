package menu.model.service.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.model.MenuCategory;

public class CategoryService implements CategorySuggester {
    private final NumberGenerator numberGenerator;
    private List<Integer> categoryIds;

    public CategoryService(NumberGenerator numberGenerator) {
        this.categoryIds = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    @Override
    public List<MenuCategory> pickCategories() {
        List<MenuCategory> categories = new ArrayList<>();
        pickUntilGetFiveAvailableCategoryIds();
        for (Integer categoryId : categoryIds) {
            categories.add(MenuCategory.getCategoryById(categoryId));
        }
        return categories;
    }

    private void pickUntilGetFiveAvailableCategoryIds() {
        while (this.categoryIds.size() < 5) {
            pickCategoryId();
        }
    }

    private void pickCategoryId() {
        int pickedNumber = numberGenerator.pick();
        if (Collections.frequency(categoryIds, pickedNumber) <= 2) {
            categoryIds.add(pickedNumber);
        }
    }
}
