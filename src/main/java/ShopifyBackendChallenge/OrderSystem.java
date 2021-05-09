package ShopifyBackendChallenge;

import ShopifyBackendChallenge.ImageInfo;
import ShopifyBackendChallenge.ImageRepository;
import java.util.HashMap;

public class OrderSystem {
    private HashMap<ImageInfo, Long> shoppingCart = new HashMap<>();
    private String user;
    private float money;
    private float orderCost = 0;

    // an expansion to the system would be to create an User object that tracks things like
    // the amount of money this user has, previous purchases, login details, etc.

    /**
     * Constructor method to create OrderSystem object
     * @param user the name/username of the user
     * @param money the amount of money this user has
     */
    public OrderSystem(String user, float money) {
        this.user = user;
        this.money = money;
    }

    /**
     * Adds item to the shopping cart/order
     * @param img the item to be added
     * @param quantity the number of that item to be added
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean addItem(ImageInfo img, long quantity) {
        return false; //dummy value for now
    }

    /**
     * Removes a certain item from the cart entirely
     * @param img the item to be removed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean removeItem(ImageInfo img) {
        return false;
    }

    /**
     * Removes a specified number of a certain item from the cart
     * @param img the item to be removed
     * @param quantity the number of the item to be removed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean removeItem(ImageInfo img, long quantity) {
        return false;
    }

    /**
     * Calculates the total order price after tax, when there is no discount
     * @return the total order price
     */
    public float checkout() {
        // TODO: calculate total order price, including tax
        return 0;
    }

    /**
     * Calculates the total order price by calculating discount first, then tax
     * @param discount decimal value that represents how much off the user gets off the order
     *                 ie 0.05 means 5% off
     * @return the total order price
     */
    public float checkout(float discount) {
        // TODO: calculate total order price, including discount and tax
        return 0;
    }

    /**
     * Helper method that incorporates the discount into the order
     * @param discount decimal value that represents how much off the user gets off the order
     *                 ie 0.05 means 5% off
     * @return the order amount after a discount
     */
    private boolean calculateDiscount(float discount) {
        return false;
    }

    // Possible improvement: support different areas and their taxation

    /**
     * Helper method that calculates the tax for the entire order
     * @return the total order amount, after tax
     */
    private float calculateTax() {
        return 0;
    }
}
