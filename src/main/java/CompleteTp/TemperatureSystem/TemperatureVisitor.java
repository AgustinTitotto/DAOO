package CompleteTp.TemperatureSystem;

public interface TemperatureVisitor {

    Double toCelsius(Celsius celsius, Double value);
    Double toCelsius(Kelvin kelvin, Double value);
    Double toCelsius(Fahrenheit fahrenheit, Double value);
}
