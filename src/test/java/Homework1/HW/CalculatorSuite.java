package Homework1.HW;

import Homework1.CalculatorTests.CalculatorDivTest;
import Homework1.CalculatorTests.CalculatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorSum.class,
        CalculatorSub.class,
        CalculatorMulti.class,
        CalculatorDiv.class
})
public class CalculatorSuite {

}
