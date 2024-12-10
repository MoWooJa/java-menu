package menu;

public class MainController {
    private final InputHandler inputHandler;

    public MainController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        Coaches temp = inputHandler.askCoachNames();
        Coaches coaches = inputHandler.askCantEatFood(temp);
    }
}
