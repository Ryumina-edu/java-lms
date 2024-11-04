package nextstep.courses.domain.session.sessionCoverImage;

import java.util.Arrays;

public enum ImageType {
    GIF("gif"),
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    SVG("svg");

    private final String type;

    ImageType(String type) {
        this.type = type;
    }

    public static boolean hasType(String fileType) {
        return Arrays.stream(ImageType.values())
                     .anyMatch(imageType -> imageType.type.equals(fileType));
    }

}
