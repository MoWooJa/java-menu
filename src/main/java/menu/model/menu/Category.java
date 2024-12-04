package menu.model.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.exception.ExceptionAnnounce;
import menu.exception.InputException;

public enum Category {

    JAPAN(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    public static final String INVALID_RANDOM_NUMBER = "[ERROR] 유효한 난수가 아닙니다.";
    private final int code;
    private final String name;
    private final List<String> menus;

    Category(int code, String name, List<String> menus) {
        this.code = code;
        this.name = name;
        this.menus = menus;
    }

    public static void validateMenuName(String menu) {
        boolean itContained = false;
        for (Category category : Category.values()) {
            Set<String> menuPool = new HashSet<>(category.menus);
            if (menuPool.contains(menu)) {
                itContained = true;
            }
        }
        validateContain(itContained);
    }

    private static void validateContain(boolean itContained) {
        if (!itContained) {
            throw new InputException(ExceptionAnnounce.NOT_CONTAINED_MENU_INPUT);
        }
    }

    public static Category getCategoryByCode(int randomCode) {
        for (Category category : Category.values()) {
            if (category.code == randomCode) {
                return category;
            }
        }
        throw new IllegalArgumentException(INVALID_RANDOM_NUMBER);
    }

    public String getMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
