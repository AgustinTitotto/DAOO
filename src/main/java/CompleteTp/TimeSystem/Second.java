package CompleteTp.TimeSystem;

public class Second implements Time, TimeVisitor{

    @Override
    public Double accept(TimeVisitor visitor, Double value) {
        return visitor.toSecond(this, value);
    }

    @Override
    public Double toSecond(Second second, Double value) {
        return value;
    }

    @Override
    public Double toSecond(Minute minute, Double value) {
        return value * 60;
    }

    @Override
    public Double toSecond(Hour hour, Double value) {
        return value * 3600;
    }
}
