package behavior;

public class NonShippable implements ShippingBehavior {
    @Override
    public double getWeight() {
        return 0;
    }
}
