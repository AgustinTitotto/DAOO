package Ejerc1.Temperatures;

public class Celsius extends TypeTemperature implements Temperature{

    private Double celsius;

    public Celsius(Double temperature) {
        super(temperature);
        this.celsius = temperature;
    }

    @Override
    public Double getCelsius() {
        return this.celsius;
    }

    @Override
    public Double getFahrenheit() {
        return (this.celsius * (9.0/5.0)) + 32.0;
    }

    @Override
    public Double getKelvin() {
        return this.celsius + 273.15;
    }
}
