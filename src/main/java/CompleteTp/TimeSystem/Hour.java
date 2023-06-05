package CompleteTp.TimeSystem;

public class Hour implements Time {

    private final double constant;

    public Hour() {
        this.constant = 3600;
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
