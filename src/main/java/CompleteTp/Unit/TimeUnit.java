package CompleteTp.Unit;

import CompleteTp.TimeSystem.Time;
import CompleteTp.TimeSystem.Unit;

public class TimeUnit extends Unit {

    private Time type;

    public TimeUnit(Time type, Integer power) {
        super(power);
        this.type = type;
    }

    public Time getType() {
        return type;
    }
}
