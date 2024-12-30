package menu.model.entity;

import static menu.view.OutputView.LINE_ENDS;
import static menu.view.OutputView.LINE_STARTS;
import static menu.view.OutputView.SEPERATOR;

import java.util.ArrayList;
import java.util.List;
import menu.view.ErrorMessage;

public class Coach {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENTH = 5;
    public static final int MENU_NUBER = 5;


    private final String name;
    private List<String> rejectedMenu;
    private List<String> selectedMenu;

    public Coach(String name) {
        validateCoachName(name);
        this.name = name;
        rejectedMenu = new ArrayList<>();
        selectedMenu = new ArrayList<>();
    }

    private void validateCoachName(String name) {
        if(name == null || name.isEmpty()|| name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENTH) {
            throw new IllegalArgumentException(ErrorMessage.DEFAULT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addRejectedMenu(String rejectedMenu) {
        this.rejectedMenu.add(rejectedMenu);
    }

    public void addSelectedMenu(String selectedMenu) {
        this.selectedMenu.add(selectedMenu);
    }

    public boolean isMenuAvailable(String menu) {
        return !(this.rejectedMenu.contains(menu) || this.selectedMenu.contains(menu));
    }

    @Override
    public String toString() {
        return LINE_STARTS + name + toStringSelectedMenu() + LINE_ENDS;
    }

    private String toStringSelectedMenu() {
        StringBuilder builder = new StringBuilder();
        for(String selectedMenu : selectedMenu) {
            builder.append(SEPERATOR);
            builder.append(selectedMenu);
        }
        return builder.toString();
    }

    public boolean isMenusReady() {
        if (selectedMenu.size() < MENU_NUBER) {
            return false;
        }
        if (selectedMenu.size() == MENU_NUBER) {
            return true;
        }
        return false;
    }
}
