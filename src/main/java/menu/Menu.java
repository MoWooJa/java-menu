package menu;

import java.util.List;

public class Menu {
    private final Category category;
    private final List<String> name;

    public Menu(Category category, List<String> name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getName() {
        return name;
    }
}
