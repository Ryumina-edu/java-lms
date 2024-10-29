package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;

public class Session {
    private Status status;

    private PayType payType;

    private Students students;

    public Session(Status status) {
        this.status = status;
    }

    public Session(Status status, PayType payType, Students students) {
        this.status = status;
        this.payType = payType;
        this.students = students;
    }

    public void apply() throws CannotApplyException {
        if (Status.RECRUIT != status) {
            throw new CannotApplyException("현재 모집중인 강의가 아닙니다.");
        }

        if (PayType.PAY == payType && students.isFull()) {
            throw new CannotApplyException("정원이 초과되어 수강 신청이 불가능합니다.");
        }
    }

}
