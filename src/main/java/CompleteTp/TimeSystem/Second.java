package CompleteTp.TimeSystem;

public class Second implements Time {

    private final double constant;

    public Second() {
        this.constant = 1;
    }

    @Override
    public double getConstant() {
        return constant;
    }

    @Override
    public boolean isDistance() {
        return false;
    }
}
