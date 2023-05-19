package CompleteTp;

import CompleteTp.Unit.MeterUnit;
import CompleteTp.Unit.TemperatureUnit;

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
                return null;
            }
            case MULTIPLICATION -> {
                return new Expr(left.getValue() * right.getValue(), new MeterUnit("m", left.getMeterUnit().getPower() + right.getMeterUnit().getPower()),
                        new TemperatureUnit("C", left.getTemperatureUnit().getPower() + right.getTemperatureUnit().getPower()),
                        null);
            }
            default -> throw new RuntimeException("Operation not supported");
        }
    }



    public Expr getLeft() {
        return left;
    }

    public Operator getOperator() {
        return operator;
    }

    public Expr getRight() {
        return right;
    }
}
