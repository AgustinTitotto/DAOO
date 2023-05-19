package CompleteTp.TimeSystem;

import CompleteTp.Expression;
import CompleteTp.Unit.Unit;


public class Time extends Expression {

    private Double value;
    private Unit unit;

    public Time(Double value, Unit unit) {
        super(value, unit);
    }

    private Double toSeconds() {
        switch (unit.getSymbol()) {
            case "s" -> {
                return this.value;
            }
            case "min" -> {
                return this.value * 60;
            }
            case "h" -> {
                return this.value * 3600;
            }
            default -> throw new RuntimeException("Unit not supported for time class");
        }
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }
}
