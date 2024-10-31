package nextstep.courses.domain;

public class SessionCoverImage {
    private Long id;
    private ImageType imageType;
    private Ratio ratio;
    private Size size;

    public SessionCoverImage(ImageType imageType, Ratio ratio, Size size) {
        this(0L, imageType, ratio, size);
    }

    public SessionCoverImage(Long id, ImageType imageType, Ratio ratio, Size size) {
        this.id = id;
        this.imageType = imageType;
        this.ratio = ratio;
        this.size = size;
    }
}
