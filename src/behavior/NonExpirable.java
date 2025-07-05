package behavior;

public class NonExpirable implements ExpireBehavior {
    @Override
    public boolean isExpired() {
        return false;
    }
}
