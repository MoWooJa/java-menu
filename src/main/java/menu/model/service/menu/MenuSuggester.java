package menu.model.service.menu;

import menu.model.MenuCategory;
import menu.model.entity.Coach;

public interface MenuSuggester {
    void suggestMenu(Coach coach, MenuCategory category);
}
