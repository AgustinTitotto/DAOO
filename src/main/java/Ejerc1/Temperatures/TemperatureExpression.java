//package Ejerc1.Temperatures;
//
//import CompleteTp.Operator;
//
//public class TemperatureExpression implements Temperature{
//
//    private Operator operator;
//    private Temperature left;
//    private Temperature right;
//
//    public TemperatureExpression(Operator operator, Temperature left, Temperature right) {
//        this.operator = operator;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public Double getCelsius() {
//        switch (operator) {
//            case PLUS -> {
//                return left.getCelsius() + right.getCelsius();
//            }
//            case MINUS -> {
//                return left.getCelsius() - right.getCelsius();
//            }
//            case MULTIPLICATION -> {
//                return left.getCelsius() * right.getCelsius();
//            }
//            case DIVISION -> {
//                return left.getCelsius() / right.getCelsius();
//            }
//            default -> throw new RuntimeException("Operation not supported");
//        }
//    }
//
//    @Override
//    public Double getFahrenheit() {
//        switch (operator) {
//            case PLUS -> {
//                return left.getFahrenheit() + right.getFahrenheit();
//            }
//            case MINUS -> {
//                return left.getFahrenheit() - right.getFahrenheit();
//            }
//            case MULTIPLICATION -> {
//                return left.getFahrenheit() * right.getFahrenheit();
//            }
//            case DIVISION -> {
//                return left.getFahrenheit() / right.getFahrenheit();
//            }
//            default -> throw new RuntimeException("Operation not supported");
//        }
//    }
//
//    @Override
//    public Double getKelvin() {
//        switch (operator) {
//            case PLUS -> {
//                return left.getKelvin() + right.getKelvin();
//            }
//            case MINUS -> {
//                return left.getKelvin() - right.getKelvin();
//            }
//            case MULTIPLICATION -> {
//                return left.getKelvin() * right.getKelvin();
//            }
//            case DIVISION -> {
//                return left.getKelvin() / right.getKelvin();
//            }
//            default -> throw new RuntimeException("Operation not supported");
//        }
//    }
//}
