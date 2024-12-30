package menu.model.service.menu;

import java.util.List;
import menu.model.MenuCategory;
import menu.model.entity.Coach;

public class MenuService implements MenuSuggester {
    private final MenuPicker picker;
    MenuCategory menuCategory;
    Coach coach;

    public MenuService(MenuPicker picker) {
        this.picker = picker;
    }

    @Override
    public void suggestMenu(Coach coach, MenuCategory category) {
        this.menuCategory = category;
        this.coach = coach;
    }

    private void pickFiveIdenticalMenus() {
        while (!coach.isMenusReady()) {
            pickMenu();
        }
    }

    private void pickMenu() {
        List<String> items =  menuCategory.getMenuItems();
        String menu = picker.pick(items);
        if(coach.isMenuAvailable(menu)) {
            coach.addSelectedMenu(menu);
        }
    }
}
