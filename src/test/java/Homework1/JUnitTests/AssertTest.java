package Homework1.JUnitTests;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {
    @Test
    public void assertTest() {
        //test data
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";
        //Variable declaration
        String string1 = "Junit";
        String string2 = "Junit";
        String string3 = "test";
        String string4 = "test";
        String string5 = null;
        int variable1 = 1;
        int variable2 = 2;
        int[] airethematicArray1 = {1 ,2 ,3 };
        int[] airethematicArray2 = {1 ,2 ,3 };

        //Assert statements
        assertEquals(string1,string2);
        assertSame(string3, string4);
        assertNotSame(string1,string3);
        assertNotNull(string1);
        assertNull(string5);
        assertTrue(variable1<variable2);
        assertArrayEquals(airethematicArray1, airethematicArray2);

        //check for equality
        assertEquals("Junit is working fine", str);

        //check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(string2);
    }


}
