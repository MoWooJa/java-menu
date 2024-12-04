package menu;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    //일식
    규동("규동",MenuCategory.JAPANESE),
    우동("우동",MenuCategory.JAPANESE),
    미소시루("미소시루",MenuCategory.JAPANESE),
    스시("스시",MenuCategory.JAPANESE),
    가츠동("가츠동",MenuCategory.JAPANESE),
    오니기리("오니기리",MenuCategory.JAPANESE),
    하이라이스("하이라이스",MenuCategory.JAPANESE),
    라멘("라멘",MenuCategory.JAPANESE),
    오코노미야끼("오코노미야끼",MenuCategory.JAPANESE),

    //한식
    김밥("김밥",MenuCategory.KOREAN),
    김치찌개("김치찌개",MenuCategory.KOREAN),
    쌈밥("쌈밥",MenuCategory.KOREAN),
    된장찌개("된장찌개",MenuCategory.KOREAN),
    비빔밥("비빔밥",MenuCategory.KOREAN),
    칼국수("칼국수",MenuCategory.KOREAN),
    불고기("불고기",MenuCategory.KOREAN),
    떡볶이("떡볶이",MenuCategory.KOREAN),
    제육볶음("제육볶음",MenuCategory.KOREAN),
    //중식
    깐풍기("깐풍기",MenuCategory.CHINESE),
    볶음면("볶음면",MenuCategory.CHINESE),
    동파육("동파육",MenuCategory.CHINESE),
    짜장면("짜장면",MenuCategory.CHINESE),
    짬뽕("짬뽕",MenuCategory.CHINESE),
    마파두부("마파두부",MenuCategory.CHINESE),
    탕수육("탕수육",MenuCategory.CHINESE),
    토마토달걀볶음("토마토 달걀볶음",MenuCategory.CHINESE),
    고추잡채("고추잡채",MenuCategory.CHINESE),

//    아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜

    //아시안
    팟타이("팟타이",MenuCategory.ASIAN),
    카오팟("카오 팟",MenuCategory.ASIAN),
    나시고렝("나시고렝",MenuCategory.ASIAN),
    파인애플볶음밥("파인애플 볶음밥",MenuCategory.ASIAN),
    쌀국수("쌀국수",MenuCategory.ASIAN),
    똠얌꿍("똠얌꿍",MenuCategory.ASIAN),
    반미("반미",MenuCategory.ASIAN),
    월남쌈("월남쌈",MenuCategory.ASIAN),
    분짜("분짜",MenuCategory.ASIAN),

    //양식
    라자냐("라자냐",MenuCategory.WESTERN),
    그라탱("그라탱",MenuCategory.WESTERN),
    뇨끼("뇨끼",MenuCategory.WESTERN),
    끼슈("끼슈",MenuCategory.WESTERN),
    프렌치토스트("프렌치 토스트",MenuCategory.WESTERN),
    바게트("바게트",MenuCategory.WESTERN),
    스파게티("스파게티",MenuCategory.WESTERN),
    피자("피자",MenuCategory.WESTERN),
    파니니("파니니",MenuCategory.WESTERN);


    private String name;
    private MenuCategory category;

    Menu(String name, MenuCategory category) {
        this.name = name;
        this.category = category;
    }
    public static List<String> getCategoryMenuList(MenuCategory category) {
        List<String> menuList = new ArrayList<>();

        for (Menu value : Menu.values()) {
            if (value.category.equals(category)) {
                menuList.add(value.name);
            }
        }
        return menuList;
    }

    public static MenuCategory getMenuCategory(String menu) {
        for (Menu value : Menu.values()) {
            if (value.name.equals(menu)) {
                return value.category;
            }

        }
        throw new IllegalArgumentException("일치하는 메뉴가 없음");
    }


}
