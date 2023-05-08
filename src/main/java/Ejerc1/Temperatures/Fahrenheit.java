package Ejerc1.Temperatures;

public class Fahrenheit extends TypeTemperature implements Temperature{

    private Double fahrenheit;

    public Fahrenheit(Double temperature) {
        super(temperature);
        this.fahrenheit = temperature;
    }

    @Override
    public Double getCelsius() {
        return (this.fahrenheit - 32) * (5.0/9.0);
    }

    @Override
    public Double getFahrenheit() {
        return this.fahrenheit;
    }

    @Override
    public Double getKelvin() {
        return (this.fahrenheit + 459.67) * (5.0/9.0);
    }
}
