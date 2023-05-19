package CompleteTp;

import CompleteTp.Unit.MeterUnit;
import CompleteTp.Unit.TemperatureUnit;
import CompleteTp.Unit.TimeUnit;

public class Expr {

    private Double value;
    private MeterUnit meterUnit;
    private TemperatureUnit temperatureUnit;
    private TimeUnit timeUnit;

    public Expr(Double value, MeterUnit meterUnit, TemperatureUnit temperatureUnit, TimeUnit timeUnit) {
        this.value = value;
        this.meterUnit = meterUnit;
        this.temperatureUnit = temperatureUnit;
        this.timeUnit = timeUnit;
    }

    public Double getValue() {
        return value;
    }

    public MeterUnit getMeterUnit() {
        return meterUnit;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
