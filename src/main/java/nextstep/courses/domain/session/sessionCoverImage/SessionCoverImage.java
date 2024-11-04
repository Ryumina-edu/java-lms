package nextstep.courses.domain.session.sessionCoverImage;

public class SessionCoverImage {
    private final SessionCoverImageType sessionCoverImageType;
    private final Ratio ratio;
    private final Size size;

    public SessionCoverImage(SessionCoverImageType sessionCoverImageType, Ratio ratio, Size size) {
        this.sessionCoverImageType = sessionCoverImageType;
        this.ratio = ratio;
        this.size = size;
    }
}
