package nextstep.courses.domain.Session;

import nextstep.courses.domain.Session.SessionCoverImage.SessionCoverImage;

public class SessionInfo {
    private final String title;
    private final SessionCoverImage sessionCoverImage;
    private final long creatorId;

    public SessionInfo(String title, SessionCoverImage sessionCoverImage, long creatorId) {
        this.title = title;
        this.sessionCoverImage = sessionCoverImage;
        this.creatorId = creatorId;
    }
}
