import behavior.*;
import product.*;
import customer.Customer;
import service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Product cheese = new Product("Cheese", 100, 10, new Expirable(LocalDate.of(2025, 7, 10)), new Shippable(0.5)); // !change
                                                                                                                       // date
                                                                                                                       // to
                                                                                                                       // test
        Product tv = new Product("TV", 3000, 5, new NonExpirable(), new Shippable(10));
        Product scratchCard = new Product("Scratch Card", 50, 20, new NonExpirable(),
                new NonShippable());// !reduce the quantity to test
        // this train ticket is not shippable but it can expire
        Product trainDigitalTickets = new Product("Digital Tickets to alexandria", 120, 180,
                new Expirable(LocalDate.of(2025, 8, 1)), new NonShippable());
        Customer customer = new Customer("John Doe", 5000);// ! reduce the balance

        customer.getCart().add(cheese, 2);
        customer.getCart().add(tv, 1);
        customer.getCart().add(scratchCard, 4);
        customer.getCart().add(trainDigitalTickets, 2);
        // customer.getCart().add(tv, -1); // ! uncomment me to test the program =)

        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        checkoutService.checkout(customer);
    }
}
