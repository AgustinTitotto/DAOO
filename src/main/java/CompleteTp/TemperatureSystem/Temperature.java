package CompleteTp.TemperatureSystem;


public interface Temperature {

    Double accept(TemperatureVisitor visitor, Double value);
}
