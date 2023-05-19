package CompleteTp.MetricSystem;


public class Meter implements Distance, DistanceVisitor{

    @Override
    public Double accept(DistanceVisitor visitor, Double value, Integer power) {
        return visitor.toMeter(this, value, power);
    }

    @Override
    public Double toMeter(Kilometer kilometer, Double value, Integer power) {
        return value * Math.pow(1000.0, power);
    }

    @Override
    public Double toMeter(Centimeter centimeter, Double value, Integer power) {
        return value / Math.pow(100.0, power);
    }

    @Override
    public Double toMeter(Meter meter, Double value, Integer power) {
        return value;
    }
}
