package menu;

public class Name {
    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }
    private void validateName(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("ERROR : 이름은 2~4글자여야 함, 0은 안됨");

        }
        if (input.length()<2 || input.length()>4) {
            throw new IllegalArgumentException("ERROR : 이름은 2~4글자");
        }
    }
    public void displayName() {
        System.out.println(name);
    }
    public String getName() {
        return name;
    }
}
