package CompleteTp.Unit;

import CompleteTp.Unit.Unit;

public class MeterUnit extends Unit {



    public MeterUnit(String symbol, Integer power) {
        super(symbol, power);
    }

    public Double toGenericValue(Double value) {
        switch (this.getSymbol()) {
            case "m" -> {
                return value;
            }
            case "km" -> {
                return value * 1000;
            }
            case "cm" -> {
                return value / 100;
            }
            default -> throw new RuntimeException("Unit not supported for meter class");
        }
    }
}
