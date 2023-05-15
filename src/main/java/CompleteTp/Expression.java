package CompleteTp;

import CompleteTp.Unit.Unit;

public class Expression {

    private Double value;
    private Unit unit;

    public Expression(Double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
