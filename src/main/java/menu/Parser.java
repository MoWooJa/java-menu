package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";

    public static List<Name> parse(String input) {
        List<Name> names = Arrays.stream(input.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());

        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("2명에서 5명 가능" + input);
        }
        return names;
    }

    public static List<String> parseHateMenu(String hateMenuStr) {
        List<String> hateItems = Arrays.stream(hateMenuStr.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        if (!hateItems.isEmpty()) {
            if (hateItems.size() > 3) {
                throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개");
            }
        }
        return hateItems;

    }
}
