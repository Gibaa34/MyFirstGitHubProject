package LoginTests;

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

public class LocatorsTests {

    WebDriver driver;
    Actions actions;
    Select select;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("user-data-dir=/path/to/your/custom/profile");
        this.driver = new ChromeDriver(options);
        this.actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void locatorsTests() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("plamenmanolov13@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("qwerty");
        driver.findElement(By.id("SubmitLogin")).click();
        //driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();
        driver.findElement(By.cssSelector("[title='Home']")).click();
        driver.findElement(By.cssSelector("[src*='img/p/1/1-home_default.jpg']")).click();
        /*driver.findElement(By.cssSelector("[class='blockbestsellers']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='homefeatured']")).click();
        //driver.findElement(By.id("homepage-slider")).click();
        driver.findElement(By.cssSelector("[src*='banner-img6.jpg']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[src*='banner-img7.jpg']")).click();*/
    }
}