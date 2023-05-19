package CompleteTp;

import CompleteTp.Operations.Expr;
import CompleteTp.Unit.DistanceUnit;
import CompleteTp.Unit.TemperatureUnit;

import java.util.Objects;

public class BinaryExpr {

    private Expr left;
    private Operator operator;
    private Expr right;

    public BinaryExpr(Expr left, Operator operator, Expr right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Expr resolve() {
        switch (operator) {
            case PLUS -> {
                if (unitsCompatible()) {
                    return new Expr(getValue(left) + getValue(right), new DistanceUnit(System.METER, left.getDistanceUnit().getPower()), new TemperatureUnit(System.CELSIUS, left.getTemperatureUnit().getPower()));
                }
                throw new RuntimeException("Incompatible units to sum");
            }
            case MULTIPLICATION -> {
                return new Expr(getValue(left) * getValue(right), new DistanceUnit(System.METER, getDistancePower()), new TemperatureUnit(System.CELSIUS, getTemperaturePower()));
            }
            default -> throw new RuntimeException("Operation not supported");
        }
    }

    private boolean unitsCompatible() {
        return  (Objects.equals(left.getDistanceUnit().getPower(), right.getDistanceUnit().getPower()) && Objects.equals(left.getTemperatureUnit().getPower(), right.getTemperatureUnit().getPower()));
    }

    private int getDistancePower() {
        return left.getDistanceUnit().getPower() + right.getDistanceUnit().getPower();
    }

    private int getTemperaturePower() {
        return left.getTemperatureUnit().getPower() + right.getTemperatureUnit().getPower();
    }

    private Double getValue(Expr expr) {
        return expr.getTemperatureUnit().getType().accept(System.CELSIUS, expr.getDistanceUnit().getType().accept(System.METER, expr.getValue(), expr.getDistanceUnit().getPower()));
    }

}
