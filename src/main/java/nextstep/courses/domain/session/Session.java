package nextstep.courses.domain.session;

import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUser;

public class Session {
    private final SessionInfo sessionInfo;

    private final Enrollment enrollment;

    private final Price price;

    private final SessionPeriod sessionPeriod;

    public Session(SessionInfo sessionInfo, Enrollment enrollment, Price price, SessionPeriod sessionPeriod) {
        this.sessionInfo = sessionInfo;
        this.enrollment = enrollment;
        this.price = price;
        this.sessionPeriod = sessionPeriod;
    }

    public void enroll(NsUser student, Payment payment) {
        price.isValid(payment);
        enrollment.enroll(student);
    }

}
