package CompleteTp.MetricSystem;

public class Centimeter implements Distance {

    private final double constant;

    public Centimeter() {
        this.constant = 0.01;
    }

    @Override
    public double getConstant() {
        return constant;
    }

    @Override
    public boolean isDistance() {
        return true;
    }
}
