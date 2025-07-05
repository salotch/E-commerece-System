package product;

import behavior.ExpireBehavior;
import behavior.ShippingBehavior;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private ExpireBehavior expireBehavior;
    private ShippingBehavior shippingBehavior;

    public Product(String name, double price, int quantity, ExpireBehavior expireBehavior,
            ShippingBehavior shippingBehavior) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expireBehavior = expireBehavior;
        this.shippingBehavior = shippingBehavior;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        return expireBehavior.isExpired();
    }

    public double getWeight() {
        return shippingBehavior.getWeight();
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity)
            throw new IllegalArgumentException("There is no enough stock");
        quantity -= amount;
    }
}
