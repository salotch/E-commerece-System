package service;

import cart.Cart;
import customer.Customer;
import product.Product;
import java.util.*;

public class CheckoutService {
    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();
        List<Product> shippableItems = new ArrayList<>();// sepreating the shipping items in a list to send it to the
                                                         // shippingservice

        double subtotal = 0;

        if (cart.isEmpty())
            throw new IllegalStateException("Cart is empty");

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > product.getQuantity())
                throw new IllegalArgumentException("there is no enough stock of " + product.getName());

            if (product.isExpired())
                throw new IllegalStateException(product.getName() + " is expired");
            subtotal += product.getPrice() * quantity;

            if (product.getWeight() > 0) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add(product);
                }
            }
        }
        // ----------------------------------------------------------------------------------------------------
        double shippingFees = shippingService.getShippingFees();// can be changed in shippingService(5EG for every kg)
        double fees = shippableItems.stream().mapToDouble(Product::getWeight).sum() * shippingFees; // 5 EGP per kg
        double total = subtotal + fees;

        // checking if the customer have that total amount of money
        if (customer.getBalance() < total)
            throw new IllegalStateException("Insufficient customer balance");

        // reduce the product quantity
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }
        // then reduce customer balance
        customer.deductBalance(total);

        // then ship the products to the customer
        if (!shippableItems.isEmpty())
            shippingService.ship(shippableItems);

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + " "
                    + (entry.getKey().getPrice() * entry.getValue()));
        }

        cart.clear(); // ! cleared the cart items
        System.out.println("----------------------");
        System.out.println("Subtotal     " + subtotal);
        System.out.println("Shipping     " + fees);
        System.out.println("Amount       " + total);
    }
}