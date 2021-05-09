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
    public OrderSystem(String user, float money) {
        this.user = user;
        this.money = money;
    }

    public boolean addItem(ImageInfo img, long quantity) {
        return false; //dummy value for now
    }

    public boolean removeItem(ImageInfo img) {
        return false;
    }

    public boolean removeItem(ImageInfo img, long quantity) {
        return false;
    }

    public float checkout() {
        // TODO: calculate total order price, including tax
        return 0;
    }

    public float checkout(float discount) {
        // TODO: calculate total order price, including discount and tax
        return 0;
    }

    private boolean calculateDiscount(float discount) {
        return false;
    }

    // Possible improvement: support different areas and their taxation
    private boolean calculateTax() {
        return false;
    }
}
