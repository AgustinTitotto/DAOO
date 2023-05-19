package CompleteTp.Unit;

import CompleteTp.MetricSystem.Distance;
import CompleteTp.TimeSystem.Unit;

public class DistanceUnit extends Unit {

    private Distance type;


    public DistanceUnit(Distance type, Integer power) {
        super(power);
        this.type = type;
    }


    public Distance getType() {
        return this.type;
    }
}
