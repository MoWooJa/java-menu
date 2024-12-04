package menu.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.model.menu.CantEats;
import menu.model.menu.Category;

public class Coach {

    private final String name;
    private final CantEats cantEats;
    private List<String> recommendedMenus;

    public Coach(String name, CantEats cantEats) {
        this.name = name;
        this.cantEats = cantEats;
    }

    public void recommended(List<Category> categories) {
        Set<String> menuPool = new HashSet<>();
        for (Category category : categories) {
            String menu = category.getMenu();
            menu = getMenu(category, menuPool, menu);
            recommendedMenus.add(menu);
        }
    }

    private String getMenu(Category category, Set<String> menuPool, String menu) {
        while (true) {
            if (cantEats.isIn(menu)) {
                continue;
            }
            if (!menuPool.add(menu)) {
                break;
            }
            menu = category.getMenu();
        }
        return menu;
    }
}
