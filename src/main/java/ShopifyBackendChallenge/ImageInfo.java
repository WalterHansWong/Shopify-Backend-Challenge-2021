package ShopifyBackendChallenge;

import java.awt.Image;

public class ImageInfo {
    private Image img;
    private String title, description, category;
    private float price, rating;

    /**
     * Constructor method that creates an image with the details of this image.
     * @param img the image
     * @param title the title/name of the image
     * @param description a written explaination of the image as a product
     * @param price the purchase cost of this image
     * @param rating the score from reviews of this image
     * @param category a grouping of similar products
     */
    public ImageInfo(Image img, String title, String description, float price, float rating, String category) {
        this.img = img;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Creates image with price only.
     * @param img
     * @param price
     */
    public ImageInfo(Image img, float price) {
        this.img = img;
        this.price = price;
    }

    /**
     * Creates image with title only.
     * @param img
     * @param title
     */
    public ImageInfo(Image img, String title) {
        this.img = img;
        this.title = title;
    }

    /**
     * Updates the price of this image object
     * @param newPrice the new price of this image
     */
    public void updatePrice(float newPrice) {
        this.price = newPrice;
    }

    /**
     * Updates the rating of this image object
     * I've chosen to directly update the rating, there would be another
     * method (uncreated) that calculates the new rating with each new review
     * @param newRating the new rating of the image
     */
    public void updateRating(float newRating) {
        this.rating = newRating;
    }

    /**
     * Methods to get the class variables
     */
    public float getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }

    public Image getImg() {
        return img;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}