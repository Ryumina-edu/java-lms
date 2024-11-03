package nextstep.courses.domain.Session;

import nextstep.courses.CannotApplyException;
import nextstep.users.domain.NsUser;

public class Enrollment {
    private Status status;
    private Students students;

    public Enrollment(Status status, Students students) {
        this.status = status;
        this.students = students;
    }

    public void enroll(NsUser student) {
        if (!status.isRecruit()) {
            throw new CannotApplyException("현재 모집중인 강의가 아닙니다.");
        }

        students.enroll(student);
    }
}