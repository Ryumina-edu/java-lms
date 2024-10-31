package nextstep.courses;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    private static final String DOT = ".";

    public static String getFileType(String fileName) {
        int lastIndex = fileName.lastIndexOf(DOT);
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex + 1);
    }

    public static int getWidth(File imageFile) throws IOException {
        return getImage(imageFile).getWidth();
    }

    public static int getHeight(File imageFile) throws IOException {
        return getImage(imageFile).getHeight();
    }

    public static BufferedImage getImage(File imageFile) throws IOException {
        return ImageIO.read(imageFile);
    }
}
