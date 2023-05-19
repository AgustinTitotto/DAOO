package CompleteTp.TimeSystem;

public interface TimeVisitor {

    Double toSecond(Second second, Double value);
    Double toSecond(Minute minute, Double value);
    Double toSecond(Hour hour, Double value);

}
