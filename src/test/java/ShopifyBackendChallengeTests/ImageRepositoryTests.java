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
        store.addImage(image1, 1);
        assertEquals(1, store.getQuantity(image1), 0.00001);
    }

    @Test
    public void RemoveImageTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 3);
        assertEquals(3, store.getQuantity(image1), 0.00001);
        assertTrue(store.removeImage(image1));
    }

    @Test
    public void BuyImageTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 3);
        assertTrue(store.buyImage(image1, 2));
        assertEquals(1, store.getQuantity(image1));
    }

    @Test
    public void BuyImageTest2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 3);
        assertFalse(store.buyImage(image1, 4));
    }

    @Test
    public void AddStockTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 3);
        store.addStock(image1, 3);
        assertEquals(6, store.getQuantity(image1));
    }
}
