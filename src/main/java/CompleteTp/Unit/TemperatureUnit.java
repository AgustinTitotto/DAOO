package CompleteTp.Unit;

import CompleteTp.TemperatureSystem.Temperature;
import CompleteTp.TimeSystem.Unit;

public class TemperatureUnit extends Unit {

    private Temperature type;

    public TemperatureUnit(Temperature type, Integer power) {
        super(power);
        this.type = type;
    }

    public Temperature getType() {
        return type;
    }
}
