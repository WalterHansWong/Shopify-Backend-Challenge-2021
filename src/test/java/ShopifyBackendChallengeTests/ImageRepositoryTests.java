package ShopifyBackendChallengeTests;

import ShopifyBackendChallenge.ImageInfo;
import ShopifyBackendChallenge.ImageRepository;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ImageRepositoryTests {
    @Test
    public void AddImageTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        String desc = "A shot of the head of a Yonex Z-Speed Badminton Racquet";
        float price = (float) 5.75;
        float rating = 4;
        String category = "Sports";
        ImageInfo image1 = new ImageInfo(img, title, desc, price, rating, category);
        ImageRepository store = new ImageRepository();
//        store.addImage(image1);
//        assertEquals(image1, store.getMostRecent());
    }
}
