package CompleteTp.TimeSystem;



public interface Time {

    Double accept(TimeVisitor visitor, Double value);

}
