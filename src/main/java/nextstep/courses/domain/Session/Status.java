package nextstep.courses.domain.Session;

public enum Status {
    PREPARE, RECRUIT, CLOSE;

    public boolean isRecruit() {
        return this == RECRUIT;
    }
}
