package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionTest {

    @Test
    @DisplayName("강의 수강신청은 강의 상태가 모집중일 때만 가능해야 한다")
    void 수강신청() {
        Session session = new Session(Status.PREPARE);

        Assertions.assertThatThrownBy(session::apply)
                  .isInstanceOf(CannotApplyException.class);
    }

    @Test
    @DisplayName("유료 강의는 강의 최대 수강 인원을 초과할 수 없다")
    void 최대_수강_인원_초과() {
        Students students = new Students(100, 100);
        Session session = new Session(Status.RECRUIT, PayType.PAY, students);

        Assertions.assertThatThrownBy(() -> {
            session.apply();
        }).isInstanceOf(CannotApplyException.class);
    }
}