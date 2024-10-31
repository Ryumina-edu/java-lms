package nextstep.courses;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ImageUtilsTest {
    private String imageUrl = "C:\\Users\\mina\\OneDrive\\바탕 화면\\Red_Apple.jpg";

    @Test
    @DisplayName("이미지 파일의 확장자를 반환한다.")
    void getFileType() {
        String fileType = ImageUtils.getFileType(new File(imageUrl).getName());
        Assertions.assertThat(fileType).isEqualTo("jpg");
    }

    @Test
    @DisplayName("이미지 파일의 width를 반환한다.")
    void getWidth() throws IOException {
        int width = ImageUtils.getWidth(new File(imageUrl));
        Assertions.assertThat(width).isEqualTo(800);
    }

    @Test
    @DisplayName("이미지 파일의 height를 반환한다.")
    void getHeight() throws IOException {
        int height = ImageUtils.getHeight(new File(imageUrl));
        Assertions.assertThat(height).isEqualTo(725);
    }

    @Test
    @DisplayName("이미지 파일을 읽어 반환한다.")
    void getImage() throws IOException {
        BufferedImage image = ImageUtils.getImage(new File(imageUrl));
        Assertions.assertThat(image).isNotNull();
    }
}