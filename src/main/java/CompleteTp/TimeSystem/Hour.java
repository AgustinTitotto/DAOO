package CompleteTp.TimeSystem;



public class Hour implements Time {

    @Override
    public Double accept(TimeVisitor visitor, Double value) {
        return visitor.toSecond(this, value);
    }
}
