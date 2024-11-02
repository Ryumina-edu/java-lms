package nextstep.courses.domain.Session;

import nextstep.courses.CannotApplyException;
import nextstep.courses.domain.Session.SessionCoverImage.Height;
import nextstep.courses.domain.Session.SessionCoverImage.Ratio;
import nextstep.courses.domain.Session.SessionCoverImage.SessionCoverImage;
import nextstep.courses.domain.Session.SessionCoverImage.SessionCoverImageType;
import nextstep.courses.domain.Session.SessionCoverImage.Size;
import nextstep.courses.domain.Session.SessionCoverImage.Width;
import nextstep.payments.domain.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class SessionTest {

    @Test
    @DisplayName("강의 수강신청은 강의 상태가 모집중일 때만 가능해야 한다")
    void 수강신청() {
        Students students = new Students(0, 100);

        SessionCoverImageType imageType = new SessionCoverImageType("jpg");
        Width width = new Width(300);
        Height height = new Height(200);
        Ratio ratio = new Ratio(width, height);
        Size size = new Size(1_048_575L);
        SessionCoverImage sessionCoverImage = new SessionCoverImage(imageType, ratio, size);

        Price price = new Price(0L);

        Session session = new Session("강의1",
                                      Status.PREPARE,
                                      PayType.FREE,
                                      students,
                                      sessionCoverImage,
                                      price,
                                      LocalDateTime.now(),
                                      LocalDateTime.now());

        Payment payment = new Payment("1", 1L, 1L, 0L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);
    }

    @Test
    @DisplayName("유료 강의는 강의 최대 수강 인원을 초과할 수 없다")
    void 최대_수강_인원_초과() {
        Students students = new Students(100, 100);

        SessionCoverImageType imageType = new SessionCoverImageType("jpg");
        Width width = new Width(300);
        Height height = new Height(200);
        Ratio ratio = new Ratio(width, height);
        Size size = new Size(1_048_575L);
        SessionCoverImage sessionCoverImage = new SessionCoverImage(imageType, ratio, size);

        Price price = new Price(800_000L);

        Session session = new Session("강의1",
                                      Status.RECRUIT,
                                      PayType.PAY,
                                      students,
                                      sessionCoverImage,
                                      price,
                                      LocalDateTime.now(),
                                      LocalDateTime.now());

        Payment payment = new Payment("1", 1L, 1L, 800_000L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);
    }

    @Test
    @DisplayName("유료 강의는 수강생이 결제한 금액과 수강료가 일치할 때 수강 신청이 가능하다")
    void 결제금액과_수강료가_일치하지_않는경우() {
        Students students = new Students(90, 100);

        SessionCoverImageType imageType = new SessionCoverImageType("jpg");
        Width width = new Width(300);
        Height height = new Height(200);
        Ratio ratio = new Ratio(width, height);
        Size size = new Size(1_048_575L);
        SessionCoverImage sessionCoverImage = new SessionCoverImage(imageType, ratio, size);

        Price price = new Price(800_000L);

        Session session = new Session("강의1",
                                      Status.RECRUIT,
                                      PayType.PAY,
                                      students,
                                      sessionCoverImage,
                                      price,
                                      LocalDateTime.now(),
                                      LocalDateTime.now());

        Payment payment = new Payment("1", 1L, 1L, 500_000L);

        Assertions.assertThatThrownBy(() -> {
            session.apply(payment);
        }).isInstanceOf(CannotApplyException.class);

    }
}
