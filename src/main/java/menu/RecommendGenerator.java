package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RecommendGenerator {

    public static Category selectCategory() {
        // String category = categories.get(Randoms.pickNumberInRange(1, 5));
        //임의로 카테고리의 순서 또는 데이터를 변경하면 안 된다.
        //Randoms.pickNumberInRange()의 결과가 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천해야 한다.
        //추천할 수 없는 카테고리인 경우 다시 Randoms.pickNumberInRange()를 통해 임의의 값을 생성해서 추천할 카테고리를 정해야 한다.
        return Category.getCategoryByIndex(Randoms.pickNumberInRange(1, 5));
    }

    public static Menus selectMenu(List<String> names) {
        //카테고리에 포함되는 메뉴 목록을 List<String> 형태로 준비한다.
        //String menu = Randoms.shuffle(menus).get(0);
        return Menus.of(Randoms.shuffle(names).get(0));
    }
}
