package CompleteTp.MetricSystem;

import CompleteTp.Operator;
import CompleteTp.Unit.Unit;

public class MeterExpression {

    private Meter left;
    private Operator operator;
    private Meter right;

    public MeterExpression(Meter left, Operator operator, Meter right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }


    public Meter resolve() {
        switch (operator) {
            case PLUS -> {
                if (left.unit().getSymbol().equals(right.unit().getSymbol()) && left.unit().getPower().equals(right.unit().getPower())) {
                    return new Meter(left.value() + right.value(), left.unit());
                }
                return new Meter(left.toMeter() + right.toMeter(), new Unit("m", left.unit().getPower()));
            }
            case MINUS -> {
                if (left.unit().getSymbol().equals(right.unit().getSymbol()) && left.unit().getPower().equals(right.unit().getPower())) {
                    return new Meter(left.value() - right.value(), left.unit());
                }
                return new Meter(left.toMeter() - right.toMeter(), new Unit("m", left.unit().getPower()));
            }
            case MULTIPLICATION -> {
                return new Meter(left.toMeter() * right.toMeter(), new Unit("m", left.unit().getPower() + right.unit().getPower()));
            }
            case DIVISION -> {
                return new Meter(left.toMeter() / right.toMeter(), new Unit("m", left.unit().getPower() - right.unit().getPower()));
            }
            default -> throw new RuntimeException("Operation not supported");
        }
    }
}
