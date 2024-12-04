package menu.model.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.exception.ExceptionAnnounce;
import menu.exception.InputException;
import menu.model.menu.CantEats;
import menu.model.menu.Category;

public class CantEatsInputParser {

    private static final String VALID_INPUT_REGEX = "[^가-힣,]";
    public static final String SEPARATOR = ",";
    public static final int MAX_CANT_EATS = 2;

    public CantEats parse(String cantEatsInput) {
        return new CantEats(validate(cantEatsInput));
    }

    private List<String> validate(String cantEatsInput) {
        validateInValidCharacter(cantEatsInput);
        if (cantEatsInput.isEmpty()) {
            return null;
        }
        List<String> cantEats = List.of(cantEatsInput.split(SEPARATOR));
        validateCantEatsSize(cantEats);
        validateDuplicatedMenus(cantEats);
        return cantEats.stream()
                .peek(Category::validateMenuName)
                .collect(Collectors.toList());
    }

    private void validateCantEatsSize(List<String> cantEats) {
        if (cantEats.size() > MAX_CANT_EATS) {
            throw new InputException(ExceptionAnnounce.MAX_OVER_CANT_EATS_INPUT_EXCEPTION);
        }
    }

    private void validateDuplicatedMenus(List<String> cantEats) {
        Set<String> cantEatsPool = new HashSet<>(cantEats);
        if (cantEats.size() != cantEatsPool.size()) {
            throw new InputException(ExceptionAnnounce.DUPLICATED_MENUS_INPUT_EXCEPTION);
        }
    }

    private void validateInValidCharacter(String input) {
        Pattern pattern = Pattern.compile(CantEatsInputParser.VALID_INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InputException(ExceptionAnnounce.INVALID_CHAR_INPUT);
        }
    }

}
