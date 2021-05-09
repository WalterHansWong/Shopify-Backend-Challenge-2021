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

    // TODO: add functions to get each of the information
}