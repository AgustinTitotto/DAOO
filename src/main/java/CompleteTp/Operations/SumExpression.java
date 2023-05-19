package CompleteTp.Operations;

import CompleteTp.System;
import CompleteTp.Unit.DistanceUnit;
import CompleteTp.Unit.TemperatureUnit;

import java.util.Objects;

public class SumExpression implements Expression{

    private Expr left;
    private Expr right;

    public SumExpression(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr getValue() {
        if (unitsCompatible()) {
            return new Expr(getValue(left) + getValue(right), new DistanceUnit(System.METER, left.getDistanceUnit().getPower()), new TemperatureUnit(System.CELSIUS, left.getTemperatureUnit().getPower()));
        }
        throw new RuntimeException("Incompatible units to sum");
    }

    private Double getValue(Expr expr) {
        return expr.getTemperatureUnit().getType().accept(System.CELSIUS, expr.getDistanceUnit().getType().accept(System.METER, expr.getValue(), expr.getDistanceUnit().getPower()));
    }

    private boolean unitsCompatible() {
        return  (Objects.equals(left.getDistanceUnit().getPower(), right.getDistanceUnit().getPower()) && Objects.equals(left.getTemperatureUnit().getPower(), right.getTemperatureUnit().getPower()));
    }
}
