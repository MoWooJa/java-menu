package menu.config;

import java.util.ArrayList;
import java.util.List;
import menu.model.MenuSuggestionSystem;
import menu.model.aggregation.Coaches;
import menu.model.entity.Coach;
import menu.view.ErrorMessage;
import menu.view.InputType;
import menu.view.InputView;
import menu.view.OutputView;

public class SystemConfig {
    private static final int MAX_ATTEMPTS = 10;
    private static final int COACH_NUMBER_MIN = 2;
    private static final int COACH_NUMBER_MAX = 5;
    InputView inputView;
    OutputView outputView;
    List<Coach> coaches;

    public SystemConfig(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.coaches = new ArrayList<>();
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public MenuSuggestionSystem getSystem() {
        repeatUntilSuccess(this::getCoaches);
        Coaches coaches = new Coaches(this.coaches);
        return new MenuSuggestionSystem(coaches);
    }

    private void getCoaches() {
        String input = inputView.getInput(InputType.COACH_NAME);
        List<String> coachNames = List.of(input.split(","));
        if(coachNames.size() > COACH_NUMBER_MAX || coachNames.size() < COACH_NUMBER_MIN) {
            throw new IllegalArgumentException(ErrorMessage.DEFAULT.getMessage());
        }
        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName);
            coaches.add(coach);
        }
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
    private static boolean tryUntillAttemptsLimit(Runnable action, int attempts) {
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

}
