package CompleteTp.TimeSystem;


import CompleteTp.Constant;

public class Hour implements Time {

    private final double constant;

    public Hour() {
        this.constant = 3600;
    }

    @Override
    public double getConstant() {
        return this.constant;
    }
}
