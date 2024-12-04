package menu.model.menu;

import java.util.List;

public class CantEats {

    private final List<String> cantEats;

    public CantEats(List<String> cantEats) {
        this.cantEats = cantEats;
    }

    public boolean isIn(String menu) {
        return cantEats.contains(menu);
    }
}
