package nextstep.courses.domain.session.enrollment;

import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private final int maxStudentCount;

    private final List<NsUser> students;

    public Students(int maxStudentCount) {
        this(maxStudentCount, new ArrayList<>());
    }

    public Students(int maxStudentCount, List<NsUser> students) {
        if (maxStudentCount < students.size()) {
            throw new IllegalArgumentException("최대 수강 인원 " + maxStudentCount + "명을 초과할 수 없습니다.");
        }

        this.maxStudentCount = maxStudentCount;
        this.students = students;
    }

    public void enroll(NsUser student) {
        students.add(student);
    }

    public boolean isFull() {
        return students.size() == maxStudentCount;
    }

    public int countOfStudent() {
        return students.size();
    }

    public boolean alreadyEnrolled(NsUser student) {
        return students.contains(student);
    }
}