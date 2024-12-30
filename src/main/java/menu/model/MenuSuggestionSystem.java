package menu.model;

import java.util.List;
import menu.model.aggregation.Coaches;

public class MenuSuggestionSystem {
    private Coaches coaches;
    private List<MenuCategory> menuCategories;

    public MenuSuggestionSystem(Coaches coaches) {
        this.coaches = coaches;
    }

    public Coaches getCoaches() {
        return coaches;
    }
}
