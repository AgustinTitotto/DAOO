package CompleteTp.MetricSystem;

import CompleteTp.Expression;
import CompleteTp.Unit.Unit;

public final class Meter extends Expression {

    private final Double value;
    private final Unit unit;

    public Meter(Double value, Unit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }

    public Double toMeter() {
        switch (unit.getSymbol()) {
            case "m" -> {
                return this.value;
            }
            case "km" -> {
                return this.value * 1000;
            }
            case "cm" -> {
                return this.value / 100;
            }
            default -> throw new RuntimeException("Unit not supported for meter class");
        }
    }

    public Double value() {
        return value;
    }

    public Unit unit() {
        return unit;
    }


}
