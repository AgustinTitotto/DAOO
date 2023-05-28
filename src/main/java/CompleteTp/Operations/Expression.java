package CompleteTp.Operations;

import CompleteTp.MetricSystem.Distance;
import CompleteTp.TimeSystem.Time;
import CompleteTp.Unit.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static CompleteTp.System.METER;
import static CompleteTp.System.SECOND;

@SuppressWarnings("ClassCanBeRecord")
public class Expression {

    private final Double value;
    private final List<Unit> units;


    public Expression(Double value, List<Unit> units) {
        this.value = value;
        this.units = units;
    }

    public Double getValue() {
        return value;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public Expression sum(Expression expression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(expression);
        if (unitsAreCompatible(left.getUnits(), right.getUnits())) {
            return new Expression(left.getValue() + right.getValue(), units);
        }
        else throw new RuntimeException("Incompatible types to sum");
    }

    public Expression multiplication(Expression expression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(expression);
        return new Expression(left.getValue() * right.getValue(), getResultUnits(left.getUnits(), right.getUnits(), true));
    }

    public Expression division(Expression expression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(expression);
        return new Expression(left.getValue() / right.getValue(), getResultUnits(left.getUnits(), right.getUnits(), false));
    }

    public Expression convertToBasic(Expression expression) {
        List<Unit> tempUnits = expression.getUnits();
        List<Unit> newUnits = new ArrayList<>();
        for (Unit unit: tempUnits) {
            if (unit.getConstant() instanceof Distance) {
                newUnits.add(new Unit(METER, unit.getPower()));
            }
            if (unit.getConstant() instanceof Time) {
                newUnits.add(new Unit(SECOND, unit.getPower()));
            }
        }
        return new Expression(getBasicValue(expression.getValue(), expression.units), newUnits);
    }

    private Double getBasicValue(Double value, List<Unit> units) {
        if (units.size() == 0) return value;
        double finalValue = 0;
        for (Unit unit: units) {
            finalValue = finalValue + unit.toConstant(value);
        }
        return finalValue;
    }

    private boolean unitsAreCompatible(List<Unit> units1, List<Unit> units2) {
        if (units1.size() != units2.size()) return false;
        List<Unit> tempList = new ArrayList<>(units2);
        for (Unit unit1 : units1) {
            boolean foundMatch = false;
            Iterator<Unit> iterator = tempList.iterator();
            while (iterator.hasNext()) {
                Unit unit2 = iterator.next();
                if (unit1.getConstant().getClass().equals(unit2.getConstant().getClass()) && unit1.getPower().equals(unit2.getPower())) {
                    iterator.remove();
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }
        return tempList.isEmpty();
    }

    private List<Unit> getResultUnits(List<Unit> units1, List<Unit> units2, boolean multiplication) {
        List<Unit> result = new ArrayList<>();
        List<Unit> tempList = new ArrayList<>(units2);
        for (Unit unit : units1) {
            boolean foundMatch = false;
            Iterator<Unit> iterator = tempList.iterator();
            while (iterator.hasNext()) {
                Unit unit2 = iterator.next();
                if (unit.getConstant().getClass().equals(unit2.getConstant().getClass())) {
                    if (multiplication && unit.getPower() + unit2.getPower() != 0) {
                        result.add(new Unit(unit.getConstant(), unit.getPower() + unit2.getPower()));
                    }
                    else if (!multiplication && unit.getPower() - unit2.getPower() != 0){
                        result.add(new Unit(unit.getConstant(), unit.getPower() - unit2.getPower()));
                    }
                    iterator.remove();
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                result.add(unit);
            }
        }
        if (!tempList.isEmpty()) {
            result.addAll(tempList);
        }
        return result;
    }
}
