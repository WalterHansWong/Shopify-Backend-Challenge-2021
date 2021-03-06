package ShopifyBackendChallengeTests;

import ShopifyBackendChallenge.ImageInfo;
import ShopifyBackendChallenge.ImageRepository;
import ShopifyBackendChallenge.OrderSystem;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class OrderSystemTests {
    @Test
    public void AddItemTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        assertTrue(order1.addItem(image1, 2));
    }

    @Test
    public void AddItemTest2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        OrderSystem order1 = new OrderSystem("Walter", 5, store);
        assertFalse(order1.addItem(image1, 2));
    }

    @Test
    public void AddItemTest3() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 10);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 1);
        order1.addItem(image1, 2);
        assertEquals(3, order1.getNumItem(image1), 0.00001);
    }

    @Test
    public void AddItemTest4() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 1);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        assertFalse(order1.addItem(image1, 2));
    }

    @Test
    public void GetNumItemTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 10);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        assertEquals(0, order1.getNumItem(image1), 0.00001);
    }

    @Test
    public void RemoveItemTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 2);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        assertTrue(order1.removeItem(image1, 1));
    }

    @Test
    public void RemoveItemTest2() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        assertFalse(order1.removeItem(image1, 3));
    }

    @Test
    public void RemoveItemTest3() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        assertTrue(order1.removeItem(image1));
    }

    @Test
    public void RemoveItemTest4() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        assertFalse(order1.removeItem(image1));
    }

    @Test
    public void RemoveItemTest5() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        assertFalse(order1.removeItem(image1, 1));
    }

    @Test
    public void CheckoutTest() throws Exception {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        assertEquals(12.075, order1.checkout((float) 0.05), 0.01);
    }

    @Test (expected = Exception.class)
    public void CheckoutTest2() throws Exception {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        order1.checkout((float) -0.05);
    }

    @Test
    public void DiscountCheckoutTest() throws Exception {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        assertEquals(11.47125, order1.checkout((float) 0.05, (float) 0.05), 0.01);
    }

    @Test (expected = Exception.class)
    public void DiscountCheckoutTest2() throws Exception {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 5);
        OrderSystem order1 = new OrderSystem("Walter", 20, store);
        order1.addItem(image1, 2);
        order1.checkout((float) 1.2, (float) 0.05);
    }
}
