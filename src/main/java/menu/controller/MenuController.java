package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Category;
import menu.domain.RecommandMenu;
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
        String[] coachesArray = inputCoaches();
        List<Coach> coaches = createCoachesInfo(coachesArray);
        RecommandMenu recommandMenu = menuService.createRecommandMenu(coaches);
        outputView.displayRecommandMenu(recommandMenu.createRecommandMenu());
    }

    private void startMenuSuggest() {
        outputView.startMenuSuggest();
    }

    private String[] inputCoaches() {
        while (true) {
            try {
                String inputCoaches = inputView.inputCoaches();
                return InputParser.parseStringToArray(inputCoaches);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private List<Coach> createCoachesInfo(String[] coachesArray) {
        List<Coach> coaches = new ArrayList<>();
        while (true) {
            try {
                for (String coachName : coachesArray) {
                    List<String> nonFood = inputOrderNonFood(coachName);
                    Coach coach = new Coach(coachName, nonFood);
                    coaches.add(coach);
                }
                return coaches;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private List<String> inputOrderNonFood(String coachName) {
        String inputMenu = inputView.inputMenu(coachName);
        return InputParser.parseStringToList(inputMenu);

    }
}
