package menu;

public class MainController {
    private final InputHandler inputHandler;
    private final RecommendService recommendService;

    public MainController(InputHandler inputHandler, RecommendService recommendService) {
        this.inputHandler = inputHandler;
        this.recommendService = recommendService;
    }

    public void run() {
        Coaches temp = inputHandler.askCoachNames();
        Coaches coaches = inputHandler.askCantEatFood(temp);
    }
}
