package CompleteTp.TimeSystem;

import CompleteTp.Constant;

public class Minute implements Time {

    private final double constant;

    public Minute() {
        this.constant = 60;
    }

    @Override
    public double getConstant() {
        return this.constant;
    }
}
