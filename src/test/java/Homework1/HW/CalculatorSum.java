package Homework1.HW;

import Calculator.Calculator;
import org.junit.*;

public class CalculatorSum {
    Calculator calc;

    @BeforeClass
    public static void setUpClass() {
        System.out.println(CalculatorSum.class.getSimpleName() + " tests starting:");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println(CalculatorSum.class.getSimpleName() + " tests finished!");
    }

    @Test
    public void calculateSum1() {
        double a = 5;
        double b = 2;
        double result = 77;
        Assert.assertTrue(a+b == result);
        System.out.println(result);
    }

    @Test
    public void calculateSum2() {
        double a = 7;
        double b = 14;
        double result = 21;
        Assert.assertEquals(result,calc.sum(a,b),0.01);
        System.out.println(result);
    }

    @Test
    public void calculateSum3() {
        double a = 21;
        double b = 13;
        double result = 34;
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
