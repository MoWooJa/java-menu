package menu.util.parser;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.util.validate.InputValidate;

public class InputParser {

    public static String[] parseStringToArray(String input) {
        String[]arrCoach = input.split(",");
        InputValidate.validateInputCoachesCount(arrCoach);
        return arrCoach;
    }

    public static List<String> parseStringToList(String inputMenu) {
        String[] arrNonFood = inputMenu.split(",");
        InputValidate.validateInputFoodCount(arrNonFood);
        return List.of(arrNonFood);
    }

 /*   private static List<Coach> createCoaches(String[] arrCoach) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachStr : arrCoach) {
            Coach coach = new Coach(coachStr);
            coaches.add(coach);
        }
        return coaches;
    }*/
}
