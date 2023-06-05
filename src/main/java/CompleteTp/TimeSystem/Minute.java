package CompleteTp.TimeSystem;

public class Minute implements Time {

    private final double constant;

    public Minute() {
        this.constant = 60;
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
