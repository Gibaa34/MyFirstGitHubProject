package Homework1.JUnitTests;

import Calculator.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private double firstNum;
    private double secondNum;
    private double result;
    private Calculator calculator;

    @Before
    public void initialize() {calculator = new Calculator();}

    public ParameterizedTest(double first, double second, double result) {
        firstNum = first;
        secondNum = second;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection inputs() {
        return Arrays.asList(new Object[][]{
                {1 ,2 ,3 },
                {3 ,7 ,11 },
                {19, 11, 30},
                {333, 100, 433},
                {23, 25, 48}
        });
    }

    @Test
    public void parameterizedTest() {
        System.out.println("First num:" + firstNum);
        System.out.println("Second num:" + secondNum);
        System.out.println("Check sum");

        assertEquals(this.result,calculator.sum(firstNum,secondNum),0.01);
        System.out.println("Correct sum:" + calculator.sum(firstNum,secondNum));
    }
}
