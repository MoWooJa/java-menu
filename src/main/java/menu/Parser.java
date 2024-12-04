package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";
    public static List<Name> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static List<String> parseHateMenu(String hateMenuStr) {
        return Arrays.stream(hateMenuStr.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
