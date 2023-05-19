package CompleteTp.Operations;

import CompleteTp.System;
import CompleteTp.Unit.DistanceUnit;
import CompleteTp.Unit.TemperatureUnit;

public class MultiplicationExpression implements Expression{

    private Expr left;
    private Expr right;

    public MultiplicationExpression(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr getValue() {
        return new Expr(getValue(left) * getValue(right), new DistanceUnit(System.METER, getDistancePower()), new TemperatureUnit(System.CELSIUS, getTemperaturePower()));
    }

    private int getDistancePower() {
        return left.getDistanceUnit().getPower() + right.getDistanceUnit().getPower();
    }

    private int getTemperaturePower() {
        return left.getTemperatureUnit().getPower() + right.getTemperatureUnit().getPower();
    }

    private Double getValue(Expr expr) {
        if (expr.getTemperatureUnit().getPower() != 0) {
            return Math.pow(expr.getTemperatureUnit().getType().accept(System.CELSIUS, getDistancePower(expr)), expr.getTemperatureUnit().getPower());
        }
        else {
            return expr.getTemperatureUnit().getType().accept(System.CELSIUS, getDistancePower(expr));
        }
    }

    private static double getDistancePower(Expr expr) {
        Integer power = expr.getDistanceUnit().getPower();
        return expr.getDistanceUnit().getType().accept(System.METER, expr.getValue(), power);
    }
}
