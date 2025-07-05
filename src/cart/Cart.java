package cart;

import product.Product;
import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException(
                    product.getName() + " quantity and any other product must be greater than zero");
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("there is no enough stock of " + product.getName());
        // the expire and the quantity conditions are handled again in the
        // checkoutservice as the checkingout maybe done after days of adding the
        // products
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
