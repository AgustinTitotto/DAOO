package CompleteTp;

import CompleteTp.Unit.Unit;

public class BinaryExpression {

    private Expression left;
    private Operator operator;
    private Expression right;

    public BinaryExpression(Expression left, Operator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Expression resolve() {
        switch (operator) {
            case PLUS -> {
                if (left.getUnit().getSymbol().equals(right.getUnit().getSymbol()) && left.getUnit().getPower().equals(right.getUnit().getPower())) {
                    return new Expression(left.getValue() + right.getValue(), left.getUnit());
                }
                else throw new RuntimeException("Cannot add different units");
            }
            case MULTIPLICATION -> {
                if (left.getUnit().getSymbol().equals(right.getUnit().getSymbol())) {
                    return new Expression(left.getValue() * right.getValue(), new Unit(left.getUnit().getSymbol(), left.getUnit().getPower() + right.getUnit().getPower()));
                }
                return new Expression(left.getValue() * right.getValue(), new Unit(left.getUnit().getSymbol().concat(right.getUnit().getSymbol()), 1));
            }
            default -> throw new RuntimeException("Operation not supported");
        }
    }

}