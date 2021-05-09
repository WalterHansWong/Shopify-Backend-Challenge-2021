package ShopifyBackendChallenge;

import java.util.*;

public class ImageRepository {
    public static final int DSIZE = 32;

    private final int capacity;
    private HashMap<ImageInfo, Long> stock;

    /**
     * Constructor method to create image repository of a certain size.
     * @param capacity size of the repository
     */
    public ImageRepository(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Creates the image repository with default size.
     */
    public ImageRepository() { this(DSIZE); }

    // TODO: add functions to add/remove images, buy images, check if the image is in-stock, add stock(quantity), calculate discount
}