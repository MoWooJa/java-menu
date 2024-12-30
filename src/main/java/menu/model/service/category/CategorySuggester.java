package menu.model.service.category;

import java.util.List;
import menu.model.MenuCategory;

public interface CategorySuggester {
    public List<MenuCategory> pickCategories();
}
