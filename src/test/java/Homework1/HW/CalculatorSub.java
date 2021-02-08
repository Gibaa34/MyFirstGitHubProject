package Homework1.HW;

import Calculator.Calculator;
import org.junit.*;

public class CalculatorSub {
    Calculator calc;

    @BeforeClass
    public static void setUpClass() {
        System.out.println(CalculatorSub.class.getSimpleName() + " tests starting:");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println(CalculatorSub.class.getSimpleName() + " tests finished!");
    }

    @Test
    public void calculateSub1() {
        double a = 200;
        double b = 100;
        double result = 100;
        Assert.assertTrue(a-b == result);
        System.out.println(result);
    }

    @Test
    public void calculateSub2() {
        double a = 333;
        double b = 444;
        double result = -111;
        Assert.assertEquals(result,calc.subtract(a,b),0.01);
        System.out.println(result);
    }

    @Test
    public void calculateSub3() {
        double a = 0;
        double b = 0;
        double result = 0;
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
