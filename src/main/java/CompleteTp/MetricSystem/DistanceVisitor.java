package CompleteTp.MetricSystem;

public interface DistanceVisitor {

    Double toMeter(Kilometer kilometer, Double value, Integer power);
    Double toMeter(Centimeter centimeter, Double value, Integer power);
    Double toMeter(Meter meter, Double value, Integer power);
}
