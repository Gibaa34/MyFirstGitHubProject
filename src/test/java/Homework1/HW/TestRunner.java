package Homework1.HW;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(CalculatorSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("TestSuit was successful : " + result.wasSuccessful());
        System.out.println("Total tests ran : " + result.getRunCount());
        System.out.println("Tests failed : " + result.getFailureCount());
        System.out.println("Total time ran (ms) : " + result.getRunTime());
    }
}
