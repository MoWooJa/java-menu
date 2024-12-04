package menu.view.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String requestMessage;

    public InputView(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    private void showRequestMessage() {
        System.out.println(requestMessage);
    }

    public String getInput() {
        System.out.println();
        showRequestMessage();
        return Console.readLine();
    }

    private void showFormatRequestMessage(String name) {
        System.out.println(String.format(requestMessage, name));
    }

    public String getInput(String name) {
        showFormatRequestMessage(name);
        return Console.readLine();
    }
}
