package menu.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import menu.exception.ExceptionAnnounce;
import menu.exception.InputException;
import menu.model.parser.InputNamesParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputNamesParserTest {

    InputNamesParser inputNamesParser = new InputNamesParser();

    @ParameterizedTest
    @MethodSource("generateNamesInputException")
    void parse(String namesInput, String message) {
        assertThatThrownBy(() -> inputNamesParser.parse(namesInput))
                .isInstanceOf(InputException.class).hasMessage(message);
    }

    static Stream<Arguments> generateNamesInputException() {
        return Stream.of(
                Arguments.of("12,준팍,도밥,고니,수아", ExceptionAnnounce.INVALID_CHAR_INPUT.getMessage()),
                Arguments.of("abc,도밥,고니,수아", ExceptionAnnounce.INVALID_CHAR_INPUT.getMessage()),
                Arguments.of("도도,도밥,고니,수아,두두,이두", ExceptionAnnounce.MAX_OVER_NAMES_INPUT_EXCEPTION.getMessage()),
                Arguments.of("도도", ExceptionAnnounce.MIN_NAMES_INPUT_EXCEPTION.getMessage()),
                Arguments.of("도도,도밥,도도", ExceptionAnnounce.DUPLICATED_NAME_INPUT_EXCEPTION.getMessage()),
                Arguments.of(",도밥,고니,수아", ExceptionAnnounce.NAME_SIZE_EXCEPTION.getMessage()),
                Arguments.of("디,도밥,고니,수아", ExceptionAnnounce.NAME_SIZE_EXCEPTION.getMessage()),
                Arguments.of("일이삼사오,도밥,고니,수아", ExceptionAnnounce.NAME_SIZE_EXCEPTION.getMessage())
        );
    }
}