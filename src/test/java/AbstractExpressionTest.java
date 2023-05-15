import CompleteTp.*;
import CompleteTp.MetricSystem.Meter;
import CompleteTp.TemperatureSystem.Temperature;
import CompleteTp.Unit.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractExpressionTest {


    @Test
    public void addMetricExpression() {
        Meter meter1 = new Meter(10.0, new Unit("m", 1));
        Meter meter2 = new Meter(10.0, new Unit("m", 1));
        BinaryExpression binaryExpression = new BinaryExpression(meter1, Operator.PLUS, meter2);
        Expression result = binaryExpression.resolve();
        Assertions.assertEquals(20.0, result.getValue());
        Assertions.assertEquals("m", result.getUnit().getSymbol());
        Assertions.assertEquals(1, result.getUnit().getPower());
    }

    @Test
    public void multiplyDifferentExpressions() {
        Meter meter = new Meter(10.0, new Unit("m", 1));
        Temperature temperature = new Temperature(10.0, new Unit("C", 1));
        BinaryExpression binaryExpression = new BinaryExpression(meter, Operator.MULTIPLICATION, temperature);
        Expression result = binaryExpression.resolve();
        Assertions.assertEquals(100, result.getValue());
        Assertions.assertEquals("mC", result.getUnit().getSymbol());
        Assertions.assertEquals(1, result.getUnit().getPower());
    }

    @Test
    public void multiplyDifferentComplexExpressions() {
        Expression expression1 = new Expression(10.0, new Unit("mC", 1));
        Expression expression2 = new Expression(10.0, new Unit("mC", 1));
        BinaryExpression binaryExpression = new BinaryExpression(expression1, Operator.MULTIPLICATION, expression2);
        Expression result = binaryExpression.resolve();
        Assertions.assertEquals(100, result.getValue());
        Assertions.assertEquals("mC", result.getUnit().getSymbol());
        Assertions.assertEquals(2, result.getUnit().getPower());
    }

//    @Test
//    public void multiplyComplexWithSimpleExpression() {
//        Expr expression1 = new Expr(10.0, new Meter(1.0, new Unit("m", 2)), null, null);
//        Expr expression2 = new Expr(10.0, null, new Temperature(1.0, new Unit("C", 1)), null);
//        BinaryExpr binaryExpression = new BinaryExpr(expression1, Operator.MULTIPLICATION, expression2);
//        Expr result = binaryExpression.resolve();
//        Assertions.assertEquals(100, result.getValue());
//        Assertions.assertEquals(2, result.getMeterUnit().unit().getPower());
//        Assertions.assertEquals(1, result.getTemperatureUnit().unit().getPower());
//    }

}
