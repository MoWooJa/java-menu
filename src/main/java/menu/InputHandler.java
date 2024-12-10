package menu;

import java.util.function.Supplier;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Coaches askCoachNames() {
        return handle(inputView::askCoachNames);
    }

    public Coach askCantEatFood(Coach coach) {
        return handle(() -> inputView.cantEatFood(coach));
    }


    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
