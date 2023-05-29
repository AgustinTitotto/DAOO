package CompleteTp.MetricSystem;

public class Kilometer implements Distance {

    private final double constant;

    public Kilometer() {
        this.constant = 1000.0;
    }

    @Override
    public double getConstant() {
        return constant;
    }


}
