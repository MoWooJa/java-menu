package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Menus> cantEat;
    private List<Menus> eatList;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.cantEat = new ArrayList<>();
        this.eatList = new ArrayList<>();
    }

    public void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addCantEat(List<String> names) {
        if (names.size() == 1 && names.get(0).equals("")) {
            return;
        }
        if (names.size() > 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }

        for (String name : names) {
            cantEat.add(Menus.of(name));
        }
    }

    public boolean cantEat(Menus menu) {
        if (cantEat.contains(menu)) {
            return true;
        }
        return false;
    }

    public Boolean canEat(Menus menu) {
        if (cantEat.contains(menu) || eatList.contains(menu)) {
            return false;
        }
        return true;
    }

    public void addEatList(Menus menu) {
        eatList.add(menu);
    }

    public List<Menus> getEatList() {
        return eatList;
    }
}
