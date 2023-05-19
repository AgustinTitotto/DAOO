package CompleteTp.Unit;

public class TimeUnit extends Unit{

    public TimeUnit(String symbol, Integer power) {
        super(symbol, power);
    }

    public Double toGenericValue(Double value) {
        switch (this.getSymbol()) {
            case "s" -> {
                return value;
            }
            case "min" -> {
                return value * 60;
            }
            case "h" -> {
                return value * 3600;
            }
            default -> throw new RuntimeException("Unit not supported for time class");
        }
    }
}
