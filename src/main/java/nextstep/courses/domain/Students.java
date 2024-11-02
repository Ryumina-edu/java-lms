package nextstep.courses.domain;

public class Students {
    private final int studentCount;
    private final int maxStudentCount;

    public Students(int studentCount, int maxStudentCount) {
        this.studentCount = studentCount;
        this.maxStudentCount = maxStudentCount;
    }

    public boolean isFull() {
        return studentCount == maxStudentCount;
    }
}
