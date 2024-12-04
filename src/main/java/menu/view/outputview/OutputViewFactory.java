package menu.view.outputview;

import menu.model.PlannedResult;

public class OutputViewFactory {

    private OutputViewFactory() {
    }

    public static OutputView createStartOutputView() {
        return new OutputView(OutputViewType.START_HEADER.getMessage());
    }

    public static OutputView createMenuResultOutputView(PlannedResult plannedResult) {
        return new ResultView(OutputViewType.MENU_RESULT_HEADER.getMessage());
    }
}
