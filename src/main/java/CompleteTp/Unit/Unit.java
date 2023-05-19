package CompleteTp.Unit;

public abstract class Unit {

    private String symbol;
    private Integer power;

    public Unit(String symbol, Integer power) {
        this.symbol = symbol;
        this.power = power;
    }

    public abstract Double toGenericValue(Double value);

    public String getSymbol() {
        return this.symbol;
    }

    public Integer getPower() {
        return this.power;
    }
}
