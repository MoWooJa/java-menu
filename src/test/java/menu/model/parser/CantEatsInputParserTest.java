package menu.model.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import menu.exception.ExceptionAnnounce;
import menu.exception.InputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CantEatsInputParserTest {

    CantEatsInputParser CantEatsInputParser = new CantEatsInputParser();

    @ParameterizedTest
    @MethodSource("generateNamesInputException")
    void parse(String namesInput, String message) {
        assertThatThrownBy(() -> CantEatsInputParser.parse(namesInput))
                .isInstanceOf(InputException.class).hasMessage(message);
    }

    static Stream<Arguments> generateNamesInputException() {
        return Stream.of(
                Arguments.of("우동,스시시", ExceptionAnnounce.NOT_CONTAINED_MENU_INPUT.getMessage()),
                Arguments.of("스시,스시", ExceptionAnnounce.DUPLICATED_MENUS_INPUT_EXCEPTION.getMessage()),
                Arguments.of("우동,스시,미소시루,짜장면", ExceptionAnnounce.MAX_OVER_CANT_EATS_INPUT_EXCEPTION.getMessage())
        );
    }
}