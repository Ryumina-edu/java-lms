package nextstep.courses.domain.Session;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentCountTest {

    @Test
    @DisplayName("현재 학생 수와 최대 수강 인원이 동일한 경우 true를 반환한다.")
    void is_full() {
        StudentCount studentCount = new StudentCount(100, 100);
        Assertions.assertThat(studentCount.isFull()).isTrue();
    }
}
