package nextstep.courses.domain;

public class SessionCoverImageType {
    private final String sessionCoverImageType;

    public SessionCoverImageType(String sessionCoverImageType) {
        if (!ImageType.hasType(sessionCoverImageType)) {
            throw new IllegalArgumentException("이미지 확장자는 gif, jpg, jpeg, png, svg만 가능합니다.");
        }

        this.sessionCoverImageType = sessionCoverImageType;
    }

}
