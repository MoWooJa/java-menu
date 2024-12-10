package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {


    public static Coaches splitByDelimiter(String input) {
        String[] arr = input.split(",");
        List<Coach> coaches = new ArrayList<>();
        for (String name : arr) {
            coaches.add(new Coach(name));
        }
        return new Coaches(coaches);
    }

    public static List<String> splitByDelimiterFood(String input) {
        String[] arr = input.split(",");
        return Arrays.stream(arr).collect(Collectors.toList());
    }
}
