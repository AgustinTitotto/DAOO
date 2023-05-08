package Ejerc1.Expressions;

public class LiteralExpression implements Expression{

    private Double value;

    public LiteralExpression(Double value) {
        this.value = value;
    }


    @Override
    public Double getValue() {
        return this.value;
    }
}
