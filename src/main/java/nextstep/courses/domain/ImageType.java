package nextstep.courses.domain;

import java.util.Arrays;

public enum ImageType {
    GIF("gif"),
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    SVG("svg");

    private String type;

    ImageType(String type) {
        this.type = type;
    }

    public static boolean hasType(String fileType) {
        return Arrays.stream(ImageType.values())
                     .anyMatch(imageType -> imageType.type.equals(fileType));
    }

}
