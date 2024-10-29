package nextstep.courses.domain;

public class Students {

    private int studentCount;
    private int maxStudentCount;

    public Students() {
    }

    public Students(int studentCount, int maxStudentCount) {
        this.studentCount = studentCount;
        this.maxStudentCount = maxStudentCount;
    }

    public boolean isFull() {
        return studentCount == maxStudentCount;
    }
}
