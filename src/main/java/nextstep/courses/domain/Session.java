package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;
import nextstep.payments.domain.Payment;

import java.time.LocalDateTime;

public class Session {
    private Status status;

    private PayType payType;

    private Students students;

    private Price price;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Session() {
        this(Status.PREPARE);
    }

    public Session(Status status) {
        this.status = status;
    }

    public Session(Status status, PayType payType, Students students) {
        this.status = status;
        this.payType = payType;
        this.students = students;
    }

    public Session(Status status, PayType payType, Students students, Price price) {
        this.status = status;
        this.payType = payType;
        this.students = students;
        this.price = price;
    }

    public void apply(Payment payment) throws CannotApplyException {
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
