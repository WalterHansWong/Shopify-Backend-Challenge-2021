package ShopifyBackendChallenge;

import java.util.*;

public class ImageRepository {
    private HashMap<ImageInfo, Long> stock = new HashMap<>();

    /**
     * Constructor method to create image repository.
     */
    public ImageRepository() {}

    // TODO: add multithreading capability?

    /**
     * Adds an image item to the store/image repository
     * @param img the image along with its details, to be added
     * @param quantity the number of stock of this image
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean addImage(ImageInfo img, long quantity) {
        // checks to see if the image is already in the "store"
        if (stock.containsKey(img)) {
            return false;
        }

        stock.put(img, quantity);

        // checks to see if the image was successfully added to the "store"
        if (stock.containsKey(img)) {
            return true;
        }

        return false;
    }

    /**
     * Removes an image item from the store/image repository
     * @param img the image and its details, to be removed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean removeImage(ImageInfo img) {
        // checks to see if the image is in the stock
        if (!stock.containsKey(img)) {
            return false;
        }

        stock.remove(img);

        // checks to see if the image was successfully removed
        if (!stock.containsKey(img)) {
            return true;
        }

        return false;
    }

    /**
     * Allows user to buy a specified quantity of an image
     * @param img the image to be bought
     * @param quantity the number of images to be bought
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean buyImage(ImageInfo img, long quantity) {
        if (inStock(img, quantity)) {
            stock.put(img, stock.get(img) - quantity);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Helper method to check if the image is in stock, and in sufficient quantity
     * @param img the image to be checked
     * @param quantity the minimum quantity needed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    private boolean inStock(ImageInfo img, long quantity) {
        if (!stock.containsKey(img)) {
            return false;
        }
        else {
            if (stock.get(img) < quantity) {
                long deficiency = quantity - stock.get(img);
                System.out.println("Insufficient stock, missing " + deficiency + " unit(s).");
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Adds stock for an image that already exists in the store/image repository
     * @param img the image in question
     * @param quantity the amount of stock to be added
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean addStock(ImageInfo img, long quantity) {
        if (!stock.containsKey(img)) {
            return false;
        }

        stock.put(img, stock.get(img) + quantity);
        // there's no need to check that the image was added successfully here, sufficient trust in Java's HashMap functions
        return true;
    }

    /**
     * Gets the number of a specific item currently in the store
     * @param img the specific item in question
     * @return the quantity of stock
     */
    public long getQuantity(ImageInfo img) {
        if (!stock.containsKey(img)) {
            return -1; // not a magic number as 0 represents that the store has this item, but is currently out of stock
                       // whereas -1 represents that the store does not have this item
        }

        return stock.get(img);
    }
}