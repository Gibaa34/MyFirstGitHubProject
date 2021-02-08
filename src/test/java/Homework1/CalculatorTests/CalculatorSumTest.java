package Homework1.CalculatorTests;

import Calculator.Calculator;
import org.junit.*;

public class CalculatorSumTest {
    Calculator calc;

    @Before
    public void setUp() {
        System.out.println("Test " + this.getClass().getName() +" will be executed");
        calc = new Calculator();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test suite finished");
    }

    @Test
    public void calculatorSumTest() {
        String name = this.getClass().getSimpleName();
        System.out.println("Test Case Name is: " + name);

        double a = 5;
        double b = 2;
        double result = 7;
        Assert.assertEquals(result,calc.sum(a,b),0.001);
    }

    @Test
    public void calculatorMultiplyTest() {
        String name = this.getClass().getSimpleName();
        System.out.println("Test Case Name is: " + name);

        double a = 3;
        double b = 7;
        double result = 21;
        Assert.assertEquals(result,calc.multiply(a,b),0.01);
    }
}
