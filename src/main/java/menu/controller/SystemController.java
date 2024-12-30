package menu.controller;

import menu.config.SystemConfig;
import menu.model.MenuSuggestionSystem;
import menu.view.ErrorMessage;
import menu.view.InputView;
import menu.view.OutputView;

public class SystemController {
    private final int MAX_ATTEMPTS = 5; // 최대 반복 횟수
    private MenuSuggestionSystem menuSuggester;
    private final OutputView outputView;
    private final InputView inputView;

    public SystemController(SystemConfig systemConfig) {
        this.outputView = systemConfig.getOutputView();
        this.inputView = systemConfig.getInputView();
        this.menuSuggester = systemConfig.getSystem();
    }

    public void start() {
        repeatUntilSuccess(this::);
    }


    // 성공 시 break
    public void repeatUntilSuccess(Runnable action) {
        int attempts = 0;
        while (true) {
            if (tryUntillAttemptsLimit(action, attempts)) {
                break;
            }
            attempts++;
        }

    }

    // try(Runnable)-catch
    private boolean tryUntillAttemptsLimit(Runnable action, int attempts) {
        try {
            action.run();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (attempts >= MAX_ATTEMPTS) {
                throw new IllegalArgumentException(ErrorMessage.DEFAULT.getMessage());
            }
        }
        return false;
    }

    public void getRejectedMenusByEachCoach() {
        for()
        getRejectedMenus();
    }

    private void getRejectedMenus() {

    }

}
