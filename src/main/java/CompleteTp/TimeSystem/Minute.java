package CompleteTp.TimeSystem;

public class Minute implements Time {

    @Override
    public Double accept(TimeVisitor visitor, Double value) {
        return visitor.toSecond(this, value);
    }
}
