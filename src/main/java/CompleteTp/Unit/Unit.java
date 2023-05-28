package CompleteTp.Unit;

import CompleteTp.Constant;

public class Unit {

    private Constant constant;
    private Integer power;

    public Unit(Constant constant, Integer power) {
        this.constant = constant;
        this.power = power;
    }

    public Constant getConstant() {
        return constant;
    }

    public Integer getPower() {
        return power;
    }

    public double toConstant(Double value) {
        return value * Math.pow(this.constant.getConstant(), this.power);
    }
}
