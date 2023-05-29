package CompleteTp.MetricSystem;

public class Meter implements Distance {

    private final double constant;

    public Meter() {
        this.constant = 1;
    }

    @Override
    public double getConstant() {
        return constant;
    }
}
