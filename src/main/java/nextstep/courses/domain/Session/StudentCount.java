package nextstep.courses.domain.Session;

public class StudentCount {
    private final int studentCount;
    private final int maxStudentCount;

    public StudentCount(int studentCount, int maxStudentCount) {
        this.studentCount = studentCount;
        this.maxStudentCount = maxStudentCount;
    }

    public boolean isFull() {
        return studentCount == maxStudentCount;
    }
}
