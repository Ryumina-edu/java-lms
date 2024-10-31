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

    //    ImageType(String fileType) {
//        if (!ImageType.hasType(fileType)) {
//            throw new IllegalArgumentException("이미지 확장자는 gif, jpg, jpeg, png, svg만 가능합니다.");
//        }
//        this.type = fileType;
//    }

    public static boolean hasType(String fileType) {
        return Arrays.stream(ImageType.values())
                     .anyMatch(imageType -> imageType.type.equals(fileType));
    }

}
