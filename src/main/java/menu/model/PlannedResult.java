package menu.model;

import java.util.List;

public class PlannedResult {

    private final String plannedCategory;
    private final List<String> coachsPlannedMenu;

    public PlannedResult(String plannedCategory, List<String> coachsPlannedMenu) {
        this.plannedCategory = plannedCategory;
        this.coachsPlannedMenu = coachsPlannedMenu;
    }
}
