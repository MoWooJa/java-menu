package menu;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
