package CompleteTp.Operations;

import CompleteTp.Operations.Expression;
import CompleteTp.Unit.DistanceUnit;
import CompleteTp.Unit.TemperatureUnit;
import CompleteTp.Unit.TimeUnit;

public class Expr {

    private Double value;
    private DistanceUnit distanceUnit;
    private TemperatureUnit temperatureUnit;
    private TimeUnit timeUnit;


    public Expr(Double value, DistanceUnit distanceUnit, TemperatureUnit temperatureUnit) {
        this.value = value;
        this.distanceUnit = distanceUnit;
        this.temperatureUnit = temperatureUnit;
    }


    public Double getValue() {
        return value;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }
}
