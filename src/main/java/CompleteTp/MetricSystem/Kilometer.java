package CompleteTp.MetricSystem;

import CompleteTp.Constant;

public class Kilometer implements Distance {

    private final double constant;

    public Kilometer() {
        this.constant = 1000.0;
    }

    @Override
    public double getConstant() {
        return this.constant;
    }
}
