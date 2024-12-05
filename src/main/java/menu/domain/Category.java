package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {

    private String jf = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private String kf = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private String cf = " 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private String af = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private String wf = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

    Map<String, List<String>> menus = new HashMap<>();

    public Category() {
        menus.put("일식", new ArrayList<>(Arrays.asList(jf.split("\\s*,\\s*"))));
        menus.put("한식", new ArrayList<>(Arrays.asList(kf.split("\\s*,\\s*"))));
        menus.put("중식",new ArrayList<>(Arrays.asList(cf.split("\\s*,\\s*"))));
        menus.put("아시안", new ArrayList<>(Arrays.asList(af.split("\\s*,\\s*"))));
        menus.put("양식", new ArrayList<>(Arrays.asList(wf.split("\\s*,\\s*"))));
    }


    public Map<String, List<String>> getMenus() {
        return menus;
    }

    public String get(int randomValue) {
        String category = "";
        if (randomValue == 1) {category = "일식";}
        if (randomValue == 2) {category = "한식";}
        if (randomValue == 3) {category = "중식";}
        if (randomValue == 4) {category = "아시안";}
        if (randomValue == 5) {category = "양식";}
        return category;
    }

}

