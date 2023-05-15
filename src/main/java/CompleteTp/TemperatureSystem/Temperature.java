package CompleteTp.TemperatureSystem;

import CompleteTp.Expression;
import CompleteTp.Unit.Unit;

public final class Temperature extends Expression {

    private final Double value;
    private final Unit unit;

    public Temperature(Double value, Unit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }

    public Double toCelsius() {
        switch (unit.getSymbol()) {
            case "C" -> {
                return this.value;
            }
            case "K" -> {
                return this.value + 273.15;
            }
            case "F" -> {
                return (this.value * (9.0 / 5.0)) + 32.0;
            }
            default -> throw new RuntimeException("Unit not supported for temperature class");
        }
    }

    public Double value() {
        return value;
    }

    public Unit unit() {
        return unit;
    }

}
