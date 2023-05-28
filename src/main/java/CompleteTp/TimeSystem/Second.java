package CompleteTp.TimeSystem;

import CompleteTp.Constant;

public class Second implements Time {

    private final double constant;

    public Second() {
        this.constant = 1;
    }

    @Override
    public double getConstant() {
        return this.constant;
    }
}
