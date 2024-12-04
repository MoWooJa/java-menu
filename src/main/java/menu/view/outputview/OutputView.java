package menu.view.outputview;

public class OutputView {
    private final String headerMessage;

    public OutputView(String headerMessage) {
        this.headerMessage = headerMessage;
    }

    private void showHeaderMessage() {
        System.out.println(headerMessage);
    }

    public void display() {
        showHeaderMessage();
    }
}
