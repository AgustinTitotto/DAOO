import CompleteTp.MetricSystem.Meter;
import CompleteTp.Operations.Expression;
import CompleteTp.TimeSystem.Second;
import CompleteTp.Unit.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static CompleteTp.System.*;

public class AbstractExpressionTest {


    @Test
    public void testConvertToGeneral() {
        Expression expression = new Expression(1.0, List.of(new Unit(KILOMETER, 1), new Unit(MINUTE, 2)));
        Expression result = expression.convertToBasic(expression);
        Assertions.assertEquals(3600000, result.getValue());
        Assertions.assertEquals(1, result.getUnits().get(0).getPower());
        Assertions.assertEquals(2, result.getUnits().get(1).getPower());
    }

    @Test
    public void testSimpleSum() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(20.0, result.getValue());
    }

    @Test
    public void testSumWithDifferentUnitsOfSameTypeDistance() {
        Expression expression1 = new Expression(1000.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(KILOMETER, 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(2000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
    }

    @Test
    public void testSumWithDifferentUnitsOfSameTypeTime() {
        Expression expression1 = new Expression(60.0, List.of(new Unit(SECOND, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(MINUTE, 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(120.0, result.getValue());
        Assertions.assertEquals(Second.class, result.getUnits().get(0).getConstant().getClass());
    }

    @Test
    public void testSumWithDifferentUnitsInDifferentOrder() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1), new Unit(SECOND, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(SECOND, 1), new Unit(METER, 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(20.0, result.getValue());
        Assertions.assertEquals(2, result.getUnits().size());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(Second.class, result.getUnits().get(1).getConstant().getClass());
    }

    @Test
    public void testSumWithMetersAndTimeShouldNotWork() {
        Expression expression1 = new Expression(1.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(SECOND, 1)));
        Exception error = null;
        try {
            expression1.sum(expression2);
        }
        catch (Exception e) {
            error = e;
        }
        assert error != null;
        Assertions.assertEquals("Incompatible types to sum", error.getMessage());
    }

    @Test
    public void testMultiplicationOfConstantWithUnit() {
        Expression expression1 = new Expression(1000.0);
        Expression expression2 = new Expression(1.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(1000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(1, result.getUnits().get(0).getPower());
    }

    @Test
    public void testMultiplicationWithDifferentUnitsOfSameType() {
        Expression expression1 = new Expression(1000.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(KILOMETER, 1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(1000000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(2, result.getUnits().get(0).getPower());
    }

    @Test
    public void testMultiplicationWithDifferentUnitsOfDifferentType() {
        Expression expression1 = new Expression(2.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(MINUTE, 1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(120.0, result.getValue());
        Assertions.assertEquals(2.0, result.getUnits().size());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(Second.class, result.getUnits().get(1).getConstant().getClass());
    }

    @Test
    public void testMultiplicationWhenPowerGives0() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, -1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(100.0, result.getValue());
        Assertions.assertEquals(0, result.getUnits().size());
    }

    @Test
    public void testDivisionOfConstantWithUnit() {
        Expression expression1 = new Expression(1000.0);
        Expression expression2 = new Expression(1.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.division(expression2);
        Assertions.assertEquals(1000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(-1, result.getUnits().get(0).getPower());
    }

    @Test
    public void testDivisionWithDifferentUnitsOfDifferentType() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(SECOND, 1)));
        Expression result = expression1.division(expression2);
        Assertions.assertEquals(1.0, result.getValue());
        Assertions.assertEquals(2.0, result.getUnits().size());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(Second.class, result.getUnits().get(1).getConstant().getClass());
        Assertions.assertEquals(-1, result.getUnits().get(1).getPower());
    }

    @Test
    public void testDivisionWhenPowerGives0() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.division(expression2);
        Assertions.assertEquals(1.0, result.getValue());
        Assertions.assertEquals(0, result.getUnits().size());
    }

    @Test
    public void testDivisionWhenPowerGives0AndTheMultiplyUnit() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.division(expression2);
        Assertions.assertEquals(1.0, result.getValue());
        Assertions.assertEquals(0, result.getUnits().size());
        Expression expression3 = new Expression(50.0, List.of(new Unit(SECOND, 2)));
        Expression result2 = result.multiplication(expression3);
        Assertions.assertEquals(50.0, result2.getValue());
        Assertions.assertEquals(1, result2.getUnits().size());
        Assertions.assertEquals(Second.class, result2.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(2, result2.getUnits().get(0).getPower());
    }

}
