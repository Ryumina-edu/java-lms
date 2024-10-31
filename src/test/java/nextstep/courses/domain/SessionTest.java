package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;
import nextstep.payments.domain.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionTest {

    @Test
    @DisplayName("강의 수강신청은 강의 상태가 모집중일 때만 가능해야 한다")
    void 수강신청() {
        Session session = new Session("강의1");
        Payment payment = new Payment("1", 1L, 1L, 800_000L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);
    }

    @Test
    @DisplayName("유료 강의는 강의 최대 수강 인원을 초과할 수 없다")
    void 최대_수강_인원_초과() {
        Students students = new Students(100, 100);
        Session session = new Session(Status.RECRUIT, PayType.PAY, students);
        Payment payment = new Payment("1", 1L, 1L, 800_000L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);
    }

    @Test
    @DisplayName("유료 강의는 수강생이 결제한 금액과 수강료가 일치할 때 수강 신청이 가능하다")
    void 결제금액과_수강료가_일치하지_않는경우() {
        Price price = new Price(800_000);
        Students students = new Students(50, 100);
        Session session = new Session(Status.RECRUIT, PayType.PAY, students, price);

        Payment payment = new Payment("1", 1L, 1L, 500_000L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);

    }
}