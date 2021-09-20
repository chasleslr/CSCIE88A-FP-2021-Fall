package cscie88a.week2;

public class HedgeHog extends Animal implements Guard {
    @Override
    public boolean takeMedicine(boolean withTreat) {
        return false;
    }

    @Override
    public boolean guardHome() {
        return false;
    }
}
