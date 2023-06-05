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

    public Double getFactor() {
        return Math.pow(this.getConstant().getConstant(), this.getPower());
    }
}
