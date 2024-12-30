package menu.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    Coach coach;
    @BeforeEach
    void setUp() {
        String coachName = "구구";
        coach = new Coach(coachName);
    }

    @Test
    @DisplayName("코치는 이름 입력을 통해 생성된다")
    void createCoach() {
        String coachName = "구구";
        //then
        assertThat(coach.getName()).isEqualTo(coachName);
    }

    @Test
    @DisplayName("코치는 거부할 메뉴를 추가할 수 있다.")
    void addRejectedMenu() {
        coach.addRejectedMenu("규동");
        assertThat(coach.isMenuAvailable("규동")).isFalse();
    }

    @Test
    void addSelectedMenu() {
        coach.addSelectedMenu("규동");
        assertThat(coach.isMenuAvailable("규동")).isFalse();
    }
}
