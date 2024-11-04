package nextstep.courses.domain.session.sessionCoverImage;

public class SessionCoverImage {
    private SessionCoverImageType sessionCoverImageType;
    private Ratio ratio;
    private Size size;

    public SessionCoverImage(SessionCoverImageType sessionCoverImageType, Ratio ratio, Size size) {
        this.sessionCoverImageType = sessionCoverImageType;
        this.ratio = ratio;
        this.size = size;
    }
}
