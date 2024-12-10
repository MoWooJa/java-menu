package menu;

public enum Day {
    MON("월"),
    TUE("화"),
    WED("수"),
    THUR("목"),

    FRI("금");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
