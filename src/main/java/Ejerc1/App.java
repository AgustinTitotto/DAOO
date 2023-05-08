package Ejerc1;

import Ejerc1.Temperatures.Celsius;
import Ejerc1.Temperatures.Fahrenheit;
import Ejerc1.Temperatures.Temperature;
import Ejerc1.Temperatures.TemperatureExpression;

public class App {

    public static void main(String[] args) {
        Temperature temperature1 = new TemperatureExpression(Operator.PLUS, new Celsius(5.0), new Fahrenheit(75.0));
        Temperature temperature2 = new TemperatureExpression(Operator.MINUS, new Celsius(5.0), new Fahrenheit(75.0));
        Temperature temperature3 = new TemperatureExpression(Operator.MULTIPLICATION, new Celsius(5.0), new Fahrenheit(75.0));
        Temperature temperature4 = new TemperatureExpression(Operator.DIVISION, new Celsius(5.0), new Fahrenheit(75.0));
        System.out.println(temperature1.getKelvin());
        System.out.println(temperature2.getCelsius());
        System.out.println(temperature3.getFahrenheit());
        System.out.println(temperature4.getKelvin());
    }

}
