package menu.view.outputview;

public class OutputViewFactory {
    public static final String INVALID_TYPE = "잘못된 InputViewType";

    private OutputViewFactory() {
    }

    public static OutputView createStartOutputView() {
        return new OutputView(OutputViewType.START_HEADER.getMessage());
    }

    public static OutputView createMenuResultOutputView() {
        return new OutputView(OutputViewType.MENU_RESULT_HEADER.getMessage());
    }
}
