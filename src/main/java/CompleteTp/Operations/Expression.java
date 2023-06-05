package CompleteTp.Operations;

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

    public Expression(Double value) {
        this.value = value;
        this.units = new ArrayList<>();
    }

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

    public Expression sum(Expression otherExpression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(otherExpression);
        if (unitsAreCompatible(left.getUnits(), right.getUnits())) {
            return new Expression(left.getValue() + right.getValue(), units);
        }
        else throw new RuntimeException("Incompatible types to sum");
    }

    public Expression multiplication(Expression otherExpression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(otherExpression);
        return new Expression(left.getValue() * right.getValue(), getMultiplicationResultUnits(left.getUnits(), right.getUnits()));
    }

    public Expression division(Expression otherExpression) {
        Expression left = convertToBasic(this);
        Expression right = convertToBasic(otherExpression);
        return new Expression(left.getValue() / right.getValue(), getDivisionResultUnits(left.getUnits(), right.getUnits()));
    }

    public Expression convertToBasic(Expression expression) {
        List<Unit> tempUnits = expression.getUnits();
        List<Unit> newUnits = new ArrayList<>();
        for (Unit unit: tempUnits) {
            if (unit.getConstant().isDistance()) {
                newUnits.add(new Unit(METER, unit.getPower()));
            }
            if (!unit.getConstant().isDistance()) {
                newUnits.add(new Unit(SECOND, unit.getPower()));
            }
        }
        return new Expression(getBasicValue(expression.getValue(), expression.units), newUnits);
    }

    private Double getBasicValue(Double value, List<Unit> units) {
        if (units.size() == 0) return value;
        double finalValue = value;
        for (Unit unit: units) {
            finalValue = finalValue * unit.getFactor();
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

    private List<Unit> getMultiplicationResultUnits(List<Unit> units1, List<Unit> units2) {
        List<Unit> result = new ArrayList<>();
        List<Unit> tempList = new ArrayList<>(units2);
        for (Unit unit : units1) {
            boolean foundMatch = false;
            Iterator<Unit> iterator = tempList.iterator();
            while (iterator.hasNext()) {
                Unit unit2 = iterator.next();
                if (unit.getConstant().getClass().equals(unit2.getConstant().getClass())) {
                    if (unit.getPower() + unit2.getPower() != 0) {
                        result.add(new Unit(unit.getConstant(), unit.getPower() + unit2.getPower()));
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

    private List<Unit> getDivisionResultUnits(List<Unit> units1, List<Unit> units2) {
        List<Unit> result = new ArrayList<>();
        List<Unit> tempList = new ArrayList<>(units2);
        for (Unit unit : units1) {
            boolean foundMatch = false;
            Iterator<Unit> iterator = tempList.iterator();
            while (iterator.hasNext()) {
                Unit unit2 = iterator.next();
                if (unit.getConstant().getClass().equals(unit2.getConstant().getClass())) {
                    if (unit.getPower() - unit2.getPower() != 0){
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
            for (Unit unit: tempList) {
                result.add(new Unit(unit.getConstant(), unit.getPower() * (-1)));
            }
        }
        return result;
    }
}
