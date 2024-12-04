package menu;

import menu.controller.Controller;
import menu.model.MenuPlanService;
import menu.model.MenuPlanner;
import menu.view.inputview.InputView;
import menu.view.outputview.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new InputView(null), new OutputView(null),
                new MenuPlanService(new MenuPlanner()));
        controller.run();
    }
}
