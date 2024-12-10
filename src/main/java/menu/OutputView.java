package menu;

import java.util.List;

public class OutputView {
    public void printResult(List<Category> categories, Coaches coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리 ");
        for (Category category : categories) {
            System.out.printf("| %s ", category.getName());
        }
        System.out.println("]");

        for (Coach coach : coaches.getCoaches()) {
            System.out.printf("[ %s ", coach.getName());
            for (Menus menus : coach.getEatList()) {
                System.out.printf("| %s ", menus.getName());
            }
            System.out.println("]");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
