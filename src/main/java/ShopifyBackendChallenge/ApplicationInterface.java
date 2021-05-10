package ShopifyBackendChallenge;

import ShopifyBackendChallenge.ImageInfo;
import ShopifyBackendChallenge.ImageRepository;
import ShopifyBackendChallenge.OrderSystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ApplicationInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a, b, or c. Corresponding to badminton, swimming and books, respectively.");
        String item = sc.nextLine();
        String pathname = null;
        switch (item) {
            case "a":
                pathname = "badminton.jpg";
                break;
            case "b":
                pathname = "swimming.jpg";
                break;
            case "c":
                pathname = "book.jpg";
            default:
                System.out.println("Invalid Input");
                return;
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/Images/" + pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please enter your username:");
        String name = sc.nextLine();

        System.out.println("Please enter the amount of money you have:");
        float money = sc.nextFloat();

        ImageInfo image1 = new ImageInfo(img, (float) 5.75);
        ImageRepository store = new ImageRepository();
        store.addImage(image1, 10);
        OrderSystem currOrder = new OrderSystem(name, money, store);

        System.out.println("There are currently " + store.getQuantity(image1) + " unit(s) of " + pathname);
        System.out.println("Each unit costs " + image1.getPrice());
        System.out.println("How many would you like to buy?");
        long numItems = sc.nextLong();

        if (currOrder.addItem(image1, numItems)) {
            System.out.println("Thank you for shopping with Wong's, your total with tax is: " + currOrder.checkout((float) 0.05));
            System.out.println("We hope you had a wonderful experience, and remember: You can't go wrong when you shop at Wong's");
        }
        else {
            System.out.println("We were unable to complete your order with the given details, please try again.");
        }
    }
}
