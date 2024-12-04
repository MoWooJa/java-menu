package menu.model;

import java.util.ArrayList;
import java.util.List;
import menu.model.menu.CantEats;

public class MenuPlanService {

    private final MenuPlanner menuPlanner;
    private Coaches coaches;

    public MenuPlanService(MenuPlanner menuPlanner) {
        this.menuPlanner = menuPlanner;
    }

    public void generateCoaches(List<String> names, List<CantEats> cantEats) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            coaches.add(new Coach(names.get(i), cantEats.get(i)));
        }
        this.coaches = new Coaches(coaches);
    }

    public PlannedResult getResult() {
        return menuPlanner.getPlannedResult(coaches);
    }
}
