package menu;


import java.util.ArrayList;
import java.util.List;

public enum Menus {
    //일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    //한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    //중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    //아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    //양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니

    GUDONG(Category.JAPANESE, "규동"),
    WOODONG(Category.JAPANESE, "우동"),
    MISOSIROO(Category.JAPANESE, "미소시루"),
    SUSHI(Category.JAPANESE, "스시"),
    GATUDONG(Category.JAPANESE, "가츠동"),
    ONIGIRI(Category.JAPANESE, "오니기리"),

    HIRICE(Category.JAPANESE, "하이라이스"),
    RAMEN(Category.JAPANESE, "라멘"),
    OKONOMIYAKKI(Category.JAPANESE, "오꼬노미야끼"),

    // 한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음

    KIMBAP(Category.KOREAN, "김밥"),
    KIMCHISOUP(Category.KOREAN, "김치찌개"),

    SSAMBAP(Category.KOREAN, "쌈밥"),

    DONJANGSOUP(Category.KOREAN, "된장찌개"),

    BIBIMBAP(Category.KOREAN, "비빔밥"),

    CALNOODLE(Category.KOREAN, "칼국수"),

    BOOLGOGI(Category.KOREAN, "불고기"),

    TEOKBOKKI(Category.KOREAN, "떡볶이"),

    JAEYOOK(Category.KOREAN, "제육볶음"),

    //    중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    KKANPOONGGI(Category.CHINESE, "깐풍기"),
    BOKKEMNOODLE(Category.CHINESE, "볶음면"),
    DONGPAYOOK(Category.CHINESE, "동파육"),
    JAJANGNOODLE(Category.CHINESE, "짜장면"),
    JJAMPPONG(Category.CHINESE, "짬뽕"),
    MAPATOFU(Category.CHINESE, "마파두부"),
    TANGSOOYOOK(Category.CHINESE, "탕수육"),
    TODALBOK(Category.CHINESE, "토마도 달걀볶음"),
    PEPPERNOODLE(Category.CHINESE, "고추잡채"),


    //    아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    PATTAI(Category.ASIAN, "팟타이"),
    KAOPAT(Category.ASIAN, "카오 팟"),
    NASIGORANG(Category.ASIAN, "나시고렝"),
    PINAPLE(Category.ASIAN, "파인애플 볶음밥"),
    RICE_NOODLE(Category.ASIAN, "쌀국수"),
    TOMYANG(Category.ASIAN, "똠양꿍"),
    BANMI(Category.ASIAN, "반미"),
    SSAM(Category.ASIAN, "월남쌈"),
    BOONJJA(Category.ASIAN, "분짜"),

    //    양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
    LAJA(Category.WESTERN, "라자냐"),
    GRA(Category.WESTERN, "그라탱"),
    NYO(Category.WESTERN, "뇨끼"),
    KKI(Category.WESTERN, "끼슈"),
    FRENTO(Category.WESTERN, "프렌치 토스트"),
    BAGGE(Category.WESTERN, "바게트"),
    SPAGETTI(Category.WESTERN, "스파게티"),
    PIZEE(Category.WESTERN, "피자"),
    PANINI(Category.WESTERN, "파니니");


    private final Category category;
    private final String name;

    Menus(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static List<String> getByCategory(Category category) {
        List<String> menusList = new ArrayList<>();
        for (Menus menu : Menus.values()) {
            if (menu.category.equals(category)) {
                menusList.add(menu.name);
            }
        }
        return menusList;
    }

    public static Menus of(String name) {
        for (Menus menu : Menus.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("없는메뉴");
    }

    public String getName() {
        return name;
    }
}
