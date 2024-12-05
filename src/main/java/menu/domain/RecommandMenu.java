package menu.domain;

import java.util.List;

public class RecommandMenu {

    private final List<String> weeklyCategory;
    private final List<Coach> coaches;

    public RecommandMenu(List<String> weeklyCategory, List<Coach> coaches) {
        this.weeklyCategory = weeklyCategory;
        this.coaches = coaches;
    }

    public StringBuilder createRecommandMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("메뉴 추천 결과입니다.");
        appendHeader(sb);
        appendCategories(sb);
        appendCoachMenus(sb);
        sb.append("추천을 완료했습니다.");
        return sb;
    }

    private void appendHeader(StringBuilder sb) {
        sb.append("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n");
    }

    private void appendCategories(StringBuilder sb) {
        sb.append("[ 카테고리 | ");
        sb.append(String.join(" | ", weeklyCategory));
        sb.append(" ]\n");
    }
    private void appendCoachMenus(StringBuilder sb) {
        for (Coach coach : coaches) {
            appendCoachMenu(sb, coach);
        }
    }

    private void appendCoachMenu(StringBuilder sb, Coach coach) {
        sb.append("[ ")
                .append(coach.getName())
                .append(" | ");
        sb.append(String.join(" | ", coach.getOrderFood()));
        sb.append(" ]\n");
    }
}
