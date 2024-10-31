package nextstep.courses.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RatioTest {

    @Test
    @DisplayName("가로와 세로 비율이 올바르지 않은 경우 IllegalArgumentException 가 발생한다.")
    void create_올바른_비율이_아닌_경우() {
        Width width = new Width(400);
        Height height = new Height(200);

        Assertions.assertThatThrownBy(() -> {
            Ratio ratio = new Ratio(width, height);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}