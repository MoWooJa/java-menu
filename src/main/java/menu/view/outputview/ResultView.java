package menu.view.outputview;

import java.util.List;
import menu.model.PlannedResult;

public class ResultView extends OutputView {

    public static final String RESULT_MESSAGE = "[ %s ]";
    public static final String RESULT_HEADER = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String COMPLETE_MESSAGE = "추천을 완료했습니다.";

    private final PlannedResult plannedResult;

    public ResultView(String headerMessage, PlannedResult plannedResult) {
        super(headerMessage);
        this.plannedResult = plannedResult;
    }

    public void display() {
        System.out.println();
        super.display();
        System.out.println(RESULT_HEADER);
        displayResult(plannedResult);
        System.out.println();
        System.out.println(COMPLETE_MESSAGE);
    }

    private void displayResult(PlannedResult plannedResult) {
        System.out.println(formatting(plannedResult.getPlannedCategory()));
        List<String> coachsPlannedMenus = plannedResult.getCoachsPlannedMenu();
        for (String coachsPlannedMenu : coachsPlannedMenus) {
            System.out.println(formatting(coachsPlannedMenu));
        }
    }

    private String formatting(String result) {
        return String.format(RESULT_MESSAGE, result);
    }
}
