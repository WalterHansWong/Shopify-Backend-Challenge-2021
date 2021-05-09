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
        float newCost = orderCost + (img.getPrice() * quantity);
        if (newCost > money) {
            return false;
        }
        else {
            orderCost = newCost;
        }

        if (shoppingCart.containsKey(img)) {
            shoppingCart.put(img, shoppingCart.get(img) + quantity);
        }
        else {
            shoppingCart.put(img, quantity);
        }
        return true;
    }

    /**
     * Removes a certain item from the cart entirely
     * @param img the item to be removed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean removeItem(ImageInfo img) {
        if (!shoppingCart.containsKey(img)) {
            return false;
        }
        else {
            orderCost -= img.getPrice() * shoppingCart.get(img);
            shoppingCart.remove(img);
            return true;
        }
    }

    /**
     * Removes a specified number of a certain item from the cart
     * @param img the item to be removed
     * @param quantity the number of the item to be removed
     * @return boolean indicating the success(true)/failure(false) of this operation
     */
    public boolean removeItem(ImageInfo img, long quantity) {
        if (!shoppingCart.containsKey(img)) {
            return false;
        }
        else {
            if (shoppingCart.get(img) < quantity) {
                System.out.println("You are trying to remove more items than you have in the cart.");
                return false;
            }
            else {
                orderCost -= img.getPrice() * quantity;
                shoppingCart.put(img, shoppingCart.get(img) - quantity);
                return true;
            }
        }
    }

    /**
     * Calculates the total order price after tax, when there is no discount
     * @return the total order price
     */
    public float checkout(float taxRate) {
        return calculateTax(orderCost, taxRate);
    }

    /**
     * Calculates the total order price by calculating discount first, then tax
     * @param discount decimal value that represents how much off the user gets off the order
     *                 ie 0.05 means 5% off
     * @return the total order price
     */
    public float checkout(float discount, float taxRate) throws Exception {
        float discountedPrice = calculateDiscount(discount);
        return calculateTax(discountedPrice, taxRate);
    }

    /**
     * Helper method that incorporates the discount into the order
     * @param discount decimal value that represents how much off the user gets off the order
     *                 ie 0.05 means 5% off
     * @return the order amount after a discount
     */
    private float calculateDiscount(float discount) throws Exception {
        if (discount >= 0 && discount <= 1) {
            return (1 - discount) * orderCost;
        }
        else {
            throw new Exception("Discount must be between 0 and 1!");
        }
    }

    // Possible improvement: support different areas and their taxation
    /**
     * Helper method that calculates the tax for the entire order
     * @param currTotal the current order total
     * @param taxRate the tax rate expressed as a decimal ie 5% tax is represented by 0.05
     * @return the total order amount, after tax
     */
    private float calculateTax(float currTotal, float taxRate) {
        return (1 + taxRate) * currTotal;
    }
}
