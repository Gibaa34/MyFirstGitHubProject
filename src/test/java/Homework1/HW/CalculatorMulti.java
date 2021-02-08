package Homework1.HW;

import Calculator.Calculator;
import org.junit.*;

public class CalculatorMulti {
    Calculator calc;

    @BeforeClass
    public static void setUpClass() {
        System.out.println(CalculatorMulti.class.getSimpleName() + " tests starting:");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println(CalculatorMulti.class.getSimpleName() + " tests finished!");
    }

    @Test
    public void calculateMulti1() {
        double a = 200;
        double b = 100;
        double result = 2;
        Assert.assertTrue(a*b == result);
        System.out.println(result);
    }

    @Test
    public void calculateMulti2() {
        double a = 72;
        double b = 14;
        double result = 21;
        Assert.assertEquals(result,calc.multiply(a,b),0.01);
        System.out.println(result);
    }

    @Test
    public void calculateMulti3() {
        double a = 10;
        double b = 0;
        double result = 1;
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
