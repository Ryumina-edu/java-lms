package nextstep.courses.domain;

import nextstep.courses.CannotApplyException;

public class Session {
    private Status status;

    public Session(Status status) {
        this.status = status;
    }

    public void apply() throws CannotApplyException {
        if (Status.RECRUIT != status) {
            throw new CannotApplyException("현재 모집중인 강의가 아닙니다.");
        }
    }

}
