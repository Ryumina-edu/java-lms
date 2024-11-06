package nextstep.courses.domain.session.entity;

public class StudentEntity {
    private long userId;
    private long sessionId;

    public StudentEntity(long userId, long sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public long getUserId() {
        return userId;
    }

    public long getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
            "userId=" + userId +
            ", sessionId=" + sessionId +
            '}';
    }
}
