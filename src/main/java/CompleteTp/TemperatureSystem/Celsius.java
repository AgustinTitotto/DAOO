package CompleteTp.TemperatureSystem;

public class Celsius implements Temperature, TemperatureVisitor {


    @Override
    public Double accept(TemperatureVisitor visitor, Double value) {
        return visitor.toCelsius(this, value);
    }

    @Override
    public Double toCelsius(Celsius celsius, Double value) {
        return value;
    }

    @Override
    public Double toCelsius(Kelvin kelvin, Double value) {
        return value - 273.15;
    }

    @Override
    public Double toCelsius(Fahrenheit fahrenheit, Double value) {
        return (value - 32) * (5/9);
    }
}
