import CompleteTp.MetricSystem.Kilometer;
import CompleteTp.MetricSystem.Meter;
import CompleteTp.Operations.Expression;
import CompleteTp.TimeSystem.Minute;
import CompleteTp.TimeSystem.Second;
import CompleteTp.Unit.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static CompleteTp.System.METER;
import static CompleteTp.System.SECOND;

public class AbstractExpressionTest {


    @Test
    public void convertToGeneral() {
        Expression expression = new Expression(1.0, List.of(new Unit(new Kilometer(), 2), new Unit(new Minute(), 1)));
        Expression result = expression.convertToBasic(expression);
        Assertions.assertEquals(1000060.0, result.getValue());
        Assertions.assertEquals(2, result.getUnits().get(0).getPower());
        Assertions.assertEquals(1, result.getUnits().get(1).getPower());
    }

    @Test
    public void simpleSum() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(20.0, result.getValue());
    }

    @Test
    public void sumWithDifferentUnitsOfSameType() {
        Expression expression1 = new Expression(1000.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(new Kilometer(), 1)));
        Expression result = expression1.sum(expression2);
        Assertions.assertEquals(2000.0, result.getValue());
    }

    @Test
    public void sumWithMetersAndTimeShouldNotWork() {
        Expression expression1 = new Expression(1000.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(new Minute(), 1)));
        Exception error = null;
        try {
            Expression result = expression1.sum(expression2);
        }
        catch (Exception e) {
            error = e;
        }
        assert error != null;
        Assertions.assertEquals("Incompatible types to sum", error.getMessage());
    }

    @Test
    public void multiplicationWithDifferentUnitsOfSameType() {
        Expression expression1 = new Expression(1000.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(1.0, List.of(new Unit(new Kilometer(), 1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(1000000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(2, result.getUnits().get(0).getPower());
    }

    @Test
    public void multiplicationOfConstantWithUnit() {
        Expression expression1 = new Expression(1000.0, new ArrayList<>());
        Expression expression2 = new Expression(1.0, List.of(new Unit(new Kilometer(), 1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(1000000.0, result.getValue());
        Assertions.assertEquals(Meter.class, result.getUnits().get(0).getConstant().getClass());
        Assertions.assertEquals(1, result.getUnits().get(0).getPower());
    }

    @Test
    public void multiplicationWhenPowerGives0() {
        Expression expression1 = new Expression(10.0, List.of(new Unit(METER, 1)));
        Expression expression2 = new Expression(10.0, List.of(new Unit(METER, -1)));
        Expression result = expression1.multiplication(expression2);
        Assertions.assertEquals(100.0, result.getValue());
        Assertions.assertEquals(0, result.getUnits().size());
    }

    @Test
    public void divisionWhenPowerGives0AndTheMultiplyUnit() {
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
