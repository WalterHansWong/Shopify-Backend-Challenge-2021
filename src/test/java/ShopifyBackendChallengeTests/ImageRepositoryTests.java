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
    public void AddImageTest2() {
        BufferedImage img = null, img2 = null, img3 = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
            img2 = ImageIO.read(new File("./src/Images/swimming.jpg"));
            img3 = ImageIO.read(new File("./src/Images/book.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet", title2 = "Michael Phelps", title3 = "Stack of Books";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageInfo image2 = new ImageInfo(img2, title2);
        ImageInfo image3 = new ImageInfo(img3, title3);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 1);
        store.addImage(image2, 2);
        assertEquals(1, store.getQuantity(image1), 0.00001);
        assertEquals(2, store.getQuantity(image2), 0.00001);
    }

    @Test
    public void AddImageTest3() {
        BufferedImage img = null, img2 = null, img3 = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
            img2 = ImageIO.read(new File("./src/Images/swimming.jpg"));
            img3 = ImageIO.read(new File("./src/Images/book.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet", title2 = "Michael Phelps", title3 = "Stack of Books";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageInfo image2 = new ImageInfo(img2, title2);
        ImageInfo image3 = new ImageInfo(img3, title3);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 1);
        store.addImage(image2, 2);
        assertEquals(-1, store.getQuantity(image3), 0.00001);
    }

    @Test
    public void AddImageTest4() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 1);
        assertFalse(store.addImage(image1, 1));
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
    public void RemoveImageTest2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        assertFalse(store.removeImage(image1));
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
    public void BuyImageTest3() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
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

    @Test
    public void AddStockTest2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = "Badminton Racquet";
        ImageInfo image1 = new ImageInfo(img, title);
        ImageRepository store = new ImageRepository();
        assertFalse(store.addStock(image1, 3));
    }
}
