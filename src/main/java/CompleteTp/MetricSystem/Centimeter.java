package CompleteTp.MetricSystem;

import CompleteTp.Constant;

public class Centimeter implements Distance {

    private final double constant;

    public Centimeter() {
        this.constant = 0.01;
    }

    @Override
    public double getConstant() {
        return this.constant;
    }
}
