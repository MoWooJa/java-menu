package menu;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }
    private void validateName() {
    }
    public void displayName() {
        System.out.println(name);
    }
    public String getName() {
        return name;
    }
}
