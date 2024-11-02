package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;
import nextstep.payments.domain.Payment;

import java.time.LocalDateTime;

public class Session {
    private String title;

    private Status status;

    private PayType payType;

    private Students students;

    private SessionCoverImage sessionCoverImage;

    private Price price;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Session(String title,
                   PayType payType,
                   Students students,
                   SessionCoverImage sessionCoverImage,
                   Price price,
                   LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this(title, Status.PREPARE, payType, students, sessionCoverImage, price, startDateTime, endDateTime);
    }

    public Session(String title,
                   Status status,
                   PayType payType,
                   Students students,
                   SessionCoverImage sessionCoverImage,
                   Price price,
                   LocalDateTime startDateTime,
                   LocalDateTime endDateTime) {
        this.title = title;
        this.status = status;
        this.payType = payType;
        this.students = students;
        this.sessionCoverImage = sessionCoverImage;
        this.price = price;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public void apply(Payment payment) {
        if (Status.RECRUIT != status) {
            throw new CannotApplyException("현재 모집중인 강의가 아닙니다.");
        }

        if (PayType.PAY == payType && students.isFull()) {
            throw new CannotApplyException("정원이 초과되어 수강 신청이 불가능합니다.");
        }

        if (!price.isSame(payment)) {
            throw new CannotApplyException("결제 금액과 수강료가 일치하지 않습니다.");
        }

    }

}
