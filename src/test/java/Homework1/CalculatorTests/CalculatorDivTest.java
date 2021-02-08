package Homework1.CalculatorTests;

import Calculator.Calculator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorDivTest {
    @Test
    public void calculatorDivTest() {
        Calculator calc = new Calculator();

        double a =6;
        double b =2;
        double result =3;
        Assert.assertEquals(result,calc.divide(a,b),0.001);
    }

    @Test
    public void calculatorDivErrorTest() {
        Calculator calc = new Calculator();

        double a =3;
        double b =2;
        double result =3;
        Assert.assertEquals(result,calc.divide(a,b),0.001);
    }
}
