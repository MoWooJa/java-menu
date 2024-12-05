package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.exception.ErrorMessage;

public class Coach {
    private String name;
    private List<String> NonFood;
    private List<String> orderFood = new ArrayList<>();

    public Coach(String name, List<String> NonFood) {
        this.name = name;
        this.NonFood = NonFood;
        validate(name, NonFood);
    }

    private void validate(String name, List<String> nonFood) {
        validateCoachName(name);
        validateNonFood(nonFood);
    }

    private void validateCoachName(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException(ErrorMessage.NON_COACHE_NAME_SIZE.getMessage());
        }
    }

    private void validateNonFood(List<String> nonFood) {
        for (String food : nonFood) {
            if (!checkNonFood(food)) {
                throw new IllegalArgumentException(ErrorMessage.FOOD_NON_EXIST.getMessage());
            }
        }
    }

    private boolean checkNonFood(String food) {
        boolean exist = false;
        return true;
    }


    public String getName() {
        return name;
    }

    public List<String> getNonFood() {
        return NonFood;
    }

    public void addOrderFood(String menu) {
        if (NonFood.contains(menu)) {
            throw new IllegalArgumentException();
        }
        orderFood.add(menu);
    }

    public List<String> getOrderFood() {
        return orderFood;
    }
}
