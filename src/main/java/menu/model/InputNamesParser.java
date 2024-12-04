package menu.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.exception.ExceptionAnnounce;
import menu.exception.InputException;

public class InputNamesParser {

    private static final String VALID_INPUT_REGEX = "[^가-힣,]";
    public static final String SEPARATOR = ",";
    public static final int MIN_NAMES = 2;
    public static final int MAX_NAMES = 5;
    public static final int MAX_NAME = 4;
    public static final int MIN_NAME = 2;

    public Names parse(String namesInput) {
        return new Names(validate(namesInput));
    }

    private List<String> validate(String namesInput) {
        validateInValidCharacter(namesInput);
        List<String> names = List.of(namesInput.split(SEPARATOR));
        validateNamesSize(names);
        validateDuplicatedNames(names);
        return names.stream()
                .peek(this::validateNameSize)
                .collect(Collectors.toList());
    }

    private void validateNameSize(String name) {
        if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
            throw new InputException(ExceptionAnnounce.NAME_SIZE_EXCEPTION);
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        Set<String> namesPool = new HashSet<>(names);
        if (names.size() != namesPool.size()) {
            throw new InputException(ExceptionAnnounce.DUPLICATED_NAME_INPUT_EXCEPTION);
        }
    }


    private void validateNamesSize(List<String> names) {
        if (names.size() < MIN_NAMES) {
            throw new InputException(ExceptionAnnounce.MIN_NAMES_INPUT_EXCEPTION);
        }

        if (names.size() > MAX_NAMES) {
            throw new InputException(ExceptionAnnounce.MAX_OVER_NAMES_INPUT_EXCEPTION);
        }
    }

    private void validateInValidCharacter(String input) {
        Pattern pattern = Pattern.compile(InputNamesParser.VALID_INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InputException(ExceptionAnnounce.INVALID_CHAR_INPUT);
        }
    }
}
