package service;

import product.Product;
import java.util.List;

public class ShippingService {
    private double shippingFees = 5;

    public double getShippingFees() {
        return shippingFees;
    }

    public void ship(List<Product> products) {
        double totalweight = 0;
        double subweight;
        int count = 1; // to count the first item
        System.out.println("** Shipment notice **");
        Product item = products.get(0);
        subweight = item.getWeight();
        for (int i = 1; i < products.size(); i++) {
            if (item != products.get(i)) {
                System.out.println(count + "x " + item.getName() + " " + subweight + "kg");
                totalweight += subweight;
                subweight = products.get(i).getWeight();
                count = 1;
            } else {
                subweight += item.getWeight();
                count++;
            }

            item = products.get(i);
            if (i == products.size() - 1) {
                System.out.println(count + "x " + item.getName() + " " + subweight + "kg");
                totalweight += subweight;
            }
        }

        System.out.println("Total package weight " + totalweight + "kg\n");

    }
}
