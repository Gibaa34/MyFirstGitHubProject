package Homework1.JUnitTests;

import org.junit.*;

import static org.junit.Assert.fail;

public class JUnitAnnotations {
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("@BeforeClass method will be executed before the JUnit test for " + "a Class starts");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@AfterClass methid will be executed after JUnit test for " + "a Class Completed");
    }

    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every JUnit4");
    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4");
    }

    @Test
    public void testCalculateInterest() {
        System.out.println("calculateInterest");
        fail("An Example of @Test JUnit4 annotation");
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        fail("@Ignore method will not run by JUnit4");
    }

    @Test(timeout = 500)
    public void testTimeout() {
        System.out.println("@Test(timeout) can be used to enforce timeout in JUnit4 test case");
        while (1 == 1) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        System.out.println("@Test(expected) will check for specified exception during its run");
        throw new IllegalArgumentException();
    }
}
