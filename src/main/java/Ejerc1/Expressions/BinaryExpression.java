package Ejerc1.Expressions;

import Ejerc1.Operator;

public class BinaryExpression implements Expression{

    private Operator operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(Operator operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public Double getValue() {
        switch (operator) {
            case PLUS -> {
                return left.getValue() + right.getValue();
            }
            case MINUS -> {
                return left.getValue() - right.getValue();
            }
            case MULTIPLICATION -> {
                return left.getValue() * right.getValue();
            }
            case DIVISION -> {
                return left.getValue() / right.getValue();
            }
            default -> throw new RuntimeException("Operation not supported");
        }
    }
}
