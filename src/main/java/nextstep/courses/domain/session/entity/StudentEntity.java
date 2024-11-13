package nextstep.courses.domain.session.entity;

public class StudentEntity {
    private final long userId;
    private final long sessionId;
    private final boolean selected;

    public StudentEntity(long userId, long sessionId) {
        this(userId, sessionId, false);
    }

    public StudentEntity(long userId, long sessionId, boolean selected) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.selected = selected;
    }

    public long getUserId() {
        return userId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
            "userId=" + userId +
            ", sessionId=" + sessionId +
            ", selected=" + selected +
            '}';
    }
}
