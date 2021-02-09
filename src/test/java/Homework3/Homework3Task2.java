package Homework3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Homework3Task2 {

    WebDriver driver;
    Actions actions;
    Select select;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("user-data-dir=/path/to/your/custom/profile");
        this.driver = new ChromeDriver(options);
        this.actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void navigationTest() {
        driver.get("http://automationpractice.com/index.php");
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='block_top_menu']//a[@title='Women']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]//a[@title='Evening Dresses']"))).click().perform();
        select = new Select(driver.findElement(By.id("selectProductSort")));
        select.selectByValue("quantity:desc");
        System.out.println(driver.findElement(By.cssSelector("option[value='quantity:desc']")).getText());
    }
}
