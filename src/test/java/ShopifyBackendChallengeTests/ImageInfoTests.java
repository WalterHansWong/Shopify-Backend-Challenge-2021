package ShopifyBackendChallengeTests;

import ShopifyBackendChallenge.ImageInfo;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInfoTests {
    @Test
    public void ConstructorTest1() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
        }
        ImageInfo image1 = new ImageInfo(img, "ShopifyBackendChallengeTests");
    }
}