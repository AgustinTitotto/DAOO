import CompleteTp.*;
import CompleteTp.MetricSystem.Kilometer;
import CompleteTp.MetricSystem.Meter;
import CompleteTp.Operations.DivisionExpression;
import CompleteTp.Operations.Expr;
import CompleteTp.Operations.MultiplicationExpression;
import CompleteTp.Operations.SumExpression;
import CompleteTp.System;
import CompleteTp.TemperatureSystem.Celsius;
import CompleteTp.Unit.DistanceUnit;
import CompleteTp.Unit.TemperatureUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractExpressionTest {

    @Test
    public void testMeterClass() {
        Expr expression1 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 0));
        Expr expression2 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 0));
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.MULTIPLICATION, expression2);
        Expr result = binaryExpression.resolve();
        Assertions.assertEquals(100, result.getValue());
        Assertions.assertEquals(2, result.getDistanceUnit().getPower());
    }

    @Test
    public void testMetricSum() {
        Expr expression1 = new Expr(1.0, new DistanceUnit(new Kilometer(), 1), new TemperatureUnit(System.CELSIUS, 0));
        Expr expression2 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 0));
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.PLUS, expression2);
        Expr result = binaryExpression.resolve();
        Assertions.assertEquals(1010.0, result.getValue());
        Assertions.assertEquals(1, result.getDistanceUnit().getPower());
    }

    @Test
    public void testMultiplicationWithDifferentUnis() {
        Expr expression1 = new Expr(10.0, new DistanceUnit(System.METER, 0), new TemperatureUnit(System.CELSIUS, 1));
        Expr expression2 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 0));
        Assertions.assertEquals(0, expression1.getDistanceUnit().getPower());
        Assertions.assertEquals(0, expression2.getTemperatureUnit().getPower());
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.MULTIPLICATION, expression2);
        Expr result = binaryExpression.resolve();
        Assertions.assertEquals(100, result.getValue());
        Assertions.assertEquals(1, result.getDistanceUnit().getPower());
        Assertions.assertEquals(1, result.getTemperatureUnit().getPower());
    }

    @Test
    public void testMultiplicationConversion() {
        Expr expression1 = new Expr(10.0, new DistanceUnit(System.METER, 0), new TemperatureUnit(System.CELSIUS, 1));
        Expr expression2 = new Expr(1.0, new DistanceUnit(new Kilometer(), 1), new TemperatureUnit(System.CELSIUS, 0));
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.MULTIPLICATION, expression2);
        Expr result = binaryExpression.resolve();
        Assertions.assertEquals(10000.0, result.getValue());
        Assertions.assertEquals(1, result.getDistanceUnit().getPower());
        Assertions.assertEquals(Meter.class, result.getDistanceUnit().getType().getClass());
        Assertions.assertEquals(1, result.getTemperatureUnit().getPower());
    }

    @Test
    public void testAddWithDifferentPower() {
        Expr expression1 = new Expr(10.0, new DistanceUnit(System.METER, 2), new TemperatureUnit(System.CELSIUS, 1));
        Expr expression2 = new Expr(10.0, new DistanceUnit(System.METER, 2), new TemperatureUnit(System.CELSIUS, 1));
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.PLUS, expression2);
        Expr result = binaryExpression.resolve();
        Assertions.assertEquals(20.0, result.getValue());
        Assertions.assertEquals(2, result.getDistanceUnit().getPower());
        Assertions.assertEquals(1, result.getTemperatureUnit().getPower());
    }

    @Test
    public void testAddWithDifferentPowerError() {
        Expr expression1 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 1));
        Expr expression2 = new Expr(10.0, new DistanceUnit(System.METER, 2), new TemperatureUnit(System.CELSIUS, 1));
        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.PLUS, expression2);
        Exception error = null;
        try {
            Expr result = binaryExpression.resolve();
        }
        catch (Exception e) {
            error = e;
        }
        assert error != null;
        Assertions.assertEquals(error.getMessage(), "Incompatible units to sum");
    }

    //ExpressionTests

    @Test
    public void testMultipleOperations() {
        Expr expr1 = new Expr(1.0, new DistanceUnit(new Kilometer(), 1), new TemperatureUnit(System.CELSIUS, 0));
        Expr expr2 = new Expr(1.0, new DistanceUnit(System.METER, 0), new TemperatureUnit(System.CELSIUS, 1));
        Expr expr3 = new Expr(10.0, new DistanceUnit(System.METER, 1), new TemperatureUnit(System.CELSIUS, 1));
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(expr1, expr2);
        SumExpression sumExpression = new SumExpression(multiplicationExpression.getValue(), expr3);
        Expr result = sumExpression.getValue();
        Assertions.assertEquals(1010.0, result.getValue());
        Assertions.assertEquals(1, result.getDistanceUnit().getPower());
        Assertions.assertEquals(1, result.getTemperatureUnit().getPower());
    }

    @Test
    public void testDivisionOperation() {
        Expr expr1 = new Expr(1000.0, new DistanceUnit(new Kilometer(), -1), new TemperatureUnit(System.CELSIUS, 0));
        Expr expr2 = new Expr(1.0, new DistanceUnit(System.METER, 0), new TemperatureUnit(System.CELSIUS, 1));
        Expr expr3 = new Expr(10.0, new DistanceUnit(System.METER, -1), new TemperatureUnit(System.CELSIUS, -1));
        DivisionExpression divisionExpression = new DivisionExpression(expr1, expr2);
        SumExpression sumExpression = new SumExpression(divisionExpression.getValue(), expr3);
        Expr result = sumExpression.getValue();
        Assertions.assertEquals(11.0, result.getValue());
        Assertions.assertEquals(-1, result.getDistanceUnit().getPower());
        Assertions.assertEquals(-1, result.getTemperatureUnit().getPower());
    }

    @Test
    public void testMultiplication() {
        Expr expr1 = new Expr(40.0);
        Expr expr2 = new Expr(2.0, new DistanceUnit(new Meter(), 1), new TemperatureUnit(new Celsius(), 0));
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(expr1, expr2);
        Expr result = multiplicationExpression.getValue();
        Assertions.assertEquals(80.0, result.getValue());
        Assertions.assertEquals(1, result.getDistanceUnit().getPower());
        Assertions.assertEquals(System.METER, result.getDistanceUnit().getType());
    }

}
