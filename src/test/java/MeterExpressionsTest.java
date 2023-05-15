import CompleteTp.MetricSystem.Meter;
import CompleteTp.MetricSystem.MeterExpression;
import CompleteTp.Unit.Unit;
import CompleteTp.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MeterExpressionsTest {


    @Test
    public void addMetricExpressions() {
        Meter meter1 = new Meter(1000.0, new Unit("m", 1));
        Meter meter2 = new Meter(1.0, new Unit("km", 1));
        MeterExpression meterExpression = new MeterExpression(meter1, Operator.PLUS, meter2);
        Meter result = meterExpression.resolve();
        Assertions.assertEquals(2000.0, result.value());
        Assertions.assertEquals("m", result.unit().getSymbol());
        Assertions.assertEquals(1, result.unit().getPower());
    }

    @Test
    public void subtractMetricExpressions() {
        Meter meter1 = new Meter(2000.0, new Unit("m", 1));
        Meter meter2 = new Meter(1.0, new Unit("km", 1));
        MeterExpression meterExpression = new MeterExpression(meter1, Operator.MINUS, meter2);
        Meter result = meterExpression.resolve();
        Assertions.assertEquals(1000.0, result.value());
        Assertions.assertEquals("m", result.unit().getSymbol());
        Assertions.assertEquals(1, result.unit().getPower());
    }

    @Test
    public void multiplyMetricExpressions() {
        Meter meter1 = new Meter(1000.0, new Unit("m", 1));
        Meter meter2 = new Meter(1.0, new Unit("km", 1));
        MeterExpression meterExpression = new MeterExpression(meter1, Operator.MULTIPLICATION, meter2);
        Meter result = meterExpression.resolve();
        Assertions.assertEquals(1000000.0, result.value());
        Assertions.assertEquals("m", result.unit().getSymbol());
        Assertions.assertEquals(2, result.unit().getPower());
    }

    @Test
    public void divideMetricExpressions() {
        Meter meter1 = new Meter(1000.0, new Unit("m", 1));
        Meter meter2 = new Meter(1.0, new Unit("km", 1));
        MeterExpression meterExpression = new MeterExpression(meter1, Operator.DIVISION, meter2);
        Meter result = meterExpression.resolve();
        Assertions.assertEquals(1, result.value());
        Assertions.assertEquals("m", result.unit().getSymbol());
        Assertions.assertEquals(0, result.unit().getPower());
    }

    @Test
    public void addMetricExpressionsAfterMultiplication() {
        Meter meter1 = new Meter(1000.0, new Unit("m", 1));
        Meter meter2 = new Meter(1.0, new Unit("km", 1));
        MeterExpression meterExpression = new MeterExpression(meter1, Operator.MULTIPLICATION, meter2);
        Meter result = meterExpression.resolve();
        Meter meter3 = new Meter(1000000.0, new Unit("m", 2));
        MeterExpression meterExpression1 = new MeterExpression(result, Operator.PLUS, meter3);
        Meter result2 = meterExpression1.resolve();
        Assertions.assertEquals(2000000.0, result2.value());
        Assertions.assertEquals("m", result2.unit().getSymbol());
        Assertions.assertEquals(2, result2.unit().getPower());
    }
}
