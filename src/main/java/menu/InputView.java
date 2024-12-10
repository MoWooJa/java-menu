package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public Coaches askCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return InputParser.splitByDelimiter(input);
    }

    public Coach cantEatFood(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName());
        String input = Console.readLine();
        List<String> foods = InputParser.splitByDelimiterFood(input);
        coach.addCantEat(foods);
        return coach;
    }
}

