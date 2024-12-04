package menu.model;

import java.util.List;
import menu.model.menu.Category;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void recommendedMenu(List<Category> categories) {
        coaches.forEach(coach -> coach.recommended(categories));
    }
}
