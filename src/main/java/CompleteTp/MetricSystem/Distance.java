package CompleteTp.MetricSystem;

public interface Distance {

    Double accept(DistanceVisitor visitor, Double value, Integer power);
}
