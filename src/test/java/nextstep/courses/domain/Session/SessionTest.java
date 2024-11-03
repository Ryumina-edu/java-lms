package nextstep.courses.domain.Session;

import nextstep.courses.CannotApplyException;
import nextstep.courses.domain.Session.SessionCoverImage.Height;
import nextstep.courses.domain.Session.SessionCoverImage.Ratio;
import nextstep.courses.domain.Session.SessionCoverImage.SessionCoverImage;
import nextstep.courses.domain.Session.SessionCoverImage.SessionCoverImageType;
import nextstep.courses.domain.Session.SessionCoverImage.Size;
import nextstep.courses.domain.Session.SessionCoverImage.Width;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class SessionTest {

    private Session session;

    @BeforeEach
    void getSession() {
        SessionCoverImageType imageType = new SessionCoverImageType("jpg");
        Width width = new Width(300);
        Height height = new Height(200);
        Ratio ratio = new Ratio(width, height);
        Size size = new Size(1_048_575L);
        SessionCoverImage sessionCoverImage = new SessionCoverImage(imageType, ratio, size);
        SessionInfo sessionInfo = new SessionInfo("강의1", sessionCoverImage, 1L);

        Students students = new Students(10);
        Enrollment enrollment = new Enrollment(Status.RECRUIT, students);

        Price price = new Price(800_000L, PayType.PAY);

        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.now().plusDays(1L);
        SessionPeriod sessionPeriod = new SessionPeriod(startDateTime, endDateTime);

        session = new Session(sessionInfo, enrollment, price, sessionPeriod);
    }

    @Test
    void enroll_수강신청_성공케이스() {
        NsUser user1 = NsUserTest.JAVAJIGI;
        Payment payment1 = new Payment("1", 1L, 1L, 800_000L);

        NsUser user2 = NsUserTest.SANJIGI;
        Payment payment2 = new Payment("2", 1L, 2L, 800_000L);

        session.enroll(user1, payment1);
        session.enroll(user2, payment2);

        Assertions.assertThat(session).isNotNull();
    }

    @Test
    @DisplayName("결제한 금액과 수강료가 일치하지 않는 경우 수강신청에 실패한다.")
    void enroll_수강신청_실패케이스() {
        NsUser user1 = NsUserTest.JAVAJIGI;
        Payment payment1 = new Payment("1", 1L, 1L, 500_000L);

        Assertions.assertThatThrownBy(() -> {
            session.enroll(user1, payment1);
        }).isInstanceOf(CannotApplyException.class);
    }
}
