package CompleteTp.TemperatureSystem;

public class Kelvin implements Temperature {


    @Override
    public Double accept(TemperatureVisitor visitor, Double value) {
        return visitor.toCelsius(this, value);
    }
}
