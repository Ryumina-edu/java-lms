package nextstep.courses.domain.session;

public enum Status {
    PREPARE, RECRUIT, CLOSE;

    public boolean isRecruit() {
        return this == RECRUIT;
    }
}
