package menu.view.outputview;

public class OutputViewFactory {

    private OutputViewFactory() {
    }

    public static OutputView createStartOutputView() {
        return new OutputView(OutputViewType.START_HEADER.getMessage());
    }

    public static OutputView createMenuResultOutputView() {
        return new OutputView(OutputViewType.MENU_RESULT_HEADER.getMessage());
    }
}
