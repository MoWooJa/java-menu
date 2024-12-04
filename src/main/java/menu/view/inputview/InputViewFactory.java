package menu.view.inputview;


public class InputViewFactory {
    private InputViewFactory() {
    }

    public static InputView createNamesInputView() {
        return new InputView(InputViewType.NAME_REQUEST.getMessage());
    }

    public static InputView createCantEatMenuInputView() {
        return new InputView(InputViewType.CANT_EAT_MENU_REQUEST.getMessage());
    }
}
