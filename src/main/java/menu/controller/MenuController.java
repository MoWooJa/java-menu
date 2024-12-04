package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.util.parser.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }


    public void run() {
        startMenuSuggest();
        List<Coach> coaches = inputCoaches();
    }

    private void startMenuSuggest() {
        outputView.startMenuSuggest();
    }

    private List<Coach> inputCoaches() {
        while (true) {
            try {
                String inputCoaches = inputView.inputCoaches();
                return InputParser.parseStringToCoaches(inputCoaches);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
