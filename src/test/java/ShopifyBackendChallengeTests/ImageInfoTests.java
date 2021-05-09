package ShopifyBackendChallengeTests;

import ShopifyBackendChallenge.ImageInfo;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInfoTests {
    @Test
    public void GetTitleTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, "Badminton Racquet");
        assertEquals(image1.getTitle(), "Badminton Racquet");
    }

    @Test
    public void GetPriceTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        assertEquals(5.75, image1.getPrice(),0.01);
    }

    @Test
    public void GetImgTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        assertEquals( 5.75, image1.getPrice(),0.01);
    }

    @Test
    public void NullParameterTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        assertEquals(image1.getImg(), img);
    }

    @Test
    public void GetRatingTest() {
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
        assertEquals(4, image1.getRating(),0.00001);
    }

    @Test
    public void GetCategoryTest() {
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
        assertEquals(image1.getCategory(), "Sports");
    }

    @Test
    public void GetDescriptionTest() {
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
        assertEquals(image1.getDescription(), "A shot of the head of a Yonex Z-Speed Badminton Racquet");
    }

    @Test
    public void UpdatePriceTest() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/badminton.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        assertEquals(5.75, image1.getPrice(), 0.01);
        image1.updatePrice(6);
        assertEquals(6.0, image1.getPrice(),0.01);
    }

    @Test
    public void UpdateRatingTest() {
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
        assertEquals(4, image1.getRating(),0.00001);
        image1.updateRating((float) 3.8);
        assertEquals(3.8, image1.getRating(),0.00001);
    }
}