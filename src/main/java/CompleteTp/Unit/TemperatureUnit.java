package CompleteTp.Unit;

import CompleteTp.Unit.Unit;

public class TemperatureUnit extends Unit {



    public TemperatureUnit(String symbol, Integer power) {
        super(symbol, power);
    }

    public Double toGenericValue(Double value) {
        switch (this.getSymbol()) {
            case "C" -> {
                return value;
            }
            case "K" -> {
                return value + 273.15;
            }
            case "F" -> {
                return (value * (9.0 / 5.0)) + 32.0;
            }
            default -> throw new RuntimeException("Unit not supported for temperature class");
        }
    }


}
