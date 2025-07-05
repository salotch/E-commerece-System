package behavior;

public class Shippable implements ShippingBehavior {
    private double weight;

    public Shippable(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
