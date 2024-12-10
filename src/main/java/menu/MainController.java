package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private final InputHandler inputHandler;
    private final RecommendService recommendService;

    private final OutputView outputView;

    public MainController(InputHandler inputHandler, RecommendService recommendService, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.recommendService = recommendService;
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        Coaches coaches = inputHandler.askCoachNames();

        for (Coach coach : coaches.getCoaches()) {
            inputHandler.askCantEatFood(coach);
        }
        List<Category> categories = recommendService.selectCategory();
        recommendService.dayLoop(coaches, categories);
        outputView.printResult(categories, coaches);
    }
}
