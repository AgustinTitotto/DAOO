package CompleteTp.TemperatureSystem;

public class Fahrenheit implements Temperature{

    @Override
    public Double accept(TemperatureVisitor visitor, Double value) {
        return visitor.toCelsius(this, value);
    }
}
