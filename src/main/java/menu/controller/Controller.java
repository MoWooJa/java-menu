package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.exception.InputException;
import menu.model.MenuPlanService;
import menu.model.PlannedResult;
import menu.model.menu.CantEats;
import menu.model.parser.CantEatsInputParser;
import menu.model.parser.InputNamesParser;
import menu.view.inputview.InputView;
import menu.view.inputview.InputViewFactory;
import menu.view.outputview.OutputView;
import menu.view.outputview.OutputViewFactory;

public class Controller {

    private InputView inputView;
    private OutputView outputView;
    private final MenuPlanService menuPlanService;

    public Controller(InputView inputView, OutputView outputView, MenuPlanService menuPlanService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuPlanService = menuPlanService;
    }

    public void run() {
        outputView = OutputViewFactory.createStartOutputView();
        List<String> names = retryHandle(this::getNames);
        List<CantEats> cantEats = new ArrayList<>();
        for (String name : names) {
            cantEats.add(retryHandle(name));
        }
        menuPlanService.generateCoaches(names, cantEats);
        PlannedResult result = menuPlanService.getResult();
        outputView = OutputViewFactory.createMenuResultOutputView(result);
        outputView.display();
    }

    private List<String> getNames() {
        inputView = InputViewFactory.createNamesInputView();
        InputNamesParser inputNamesParser = new InputNamesParser();
        return inputNamesParser.parse(inputView.getInput());
    }

    private CantEats getCantEats(String name) {
        inputView = InputViewFactory.createCantEatMenuInputView();
        CantEatsInputParser cantEatsInputParser = new CantEatsInputParser();
        return cantEatsInputParser.parse(inputView.getInput(name));
    }

    private <T> T retryHandle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private CantEats retryHandle(String name) {
        while (true) {
            try {
                return getCantEats(name);
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
