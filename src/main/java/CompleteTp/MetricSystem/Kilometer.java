package CompleteTp.MetricSystem;

public class Kilometer implements Distance {

    public Kilometer() {

    }




    @Override
    public Double accept(DistanceVisitor visitor, Double value, Integer power) {
        return visitor.toMeter(this, value, power);
    }
}
