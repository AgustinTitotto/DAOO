package CompleteTp.MetricSystem;

public class Centimeter implements Distance {

    public Centimeter() {

    }

    @Override
    public Double accept(DistanceVisitor visitor, Double value, Integer power) {
        return visitor.toMeter(this, value, power);
    }
}
