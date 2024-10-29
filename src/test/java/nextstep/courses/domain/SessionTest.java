package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionTest {

    @Test
    @DisplayName("강의 수강신청은 강의 상태가 모집중일 때만 가능해야 한다")
    void apply() {
        Session session = new Session(Status.PREPARE);

        Assertions.assertThatThrownBy(session::apply)
                  .isInstanceOf(CannotApplyException.class);

    }
}