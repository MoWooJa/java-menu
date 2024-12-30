package menu.model.service.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ShuffleMenuPicker implements MenuPicker {

    @Override
    public String pick(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
